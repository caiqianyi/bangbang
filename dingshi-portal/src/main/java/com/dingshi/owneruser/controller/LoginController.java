package com.dingshi.owneruser.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dingshi.common.annotation.Log;
import com.dingshi.common.controller.BaseController;
import com.dingshi.common.utils.ShiroUtils;
import com.dingshi.information.service.NoticeService;
import com.dingshi.owneruser.comment.SMSContent;
import com.dingshi.owneruser.comment.SMSPlatform;
import com.dingshi.owneruser.comment.SMSTemplate;
import com.dingshi.owneruser.domain.OwnerUserDO;
import com.dingshi.owneruser.service.OwnerUserService;
import com.dingshi.smsservice.service.ISMSService;


@RestController
public class LoginController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NoticeService noticeService;
    @Autowired
    OwnerUserService userService;
    @Autowired
    private ISMSService sMSService;


    /**
     * @param phone 手机号
     * @param type  类型 0：注册   1：登录
     * @说明 发送验证码
     */
    @Log("发送验证码")
    @PostMapping("/captcha")
    Map<String, String> captcha(String phone, String type) {
        Map<String, String> message = new HashMap<>();
        try {
            if (phone == null || "".equals(phone)) {
                message.put("msg", "手机号码不能为空");
            } else {
                SMSTemplate contentType = SMSContent.ZHUCE;
                if ("0".equals(type)) {
                    contentType = SMSContent.ZHUCE;//注册
                }
                if ("1".equals(type)) {
                    contentType = SMSContent.LOGIN;//登录
                }

                Map<String, Object> map = sMSService.sendCodeNumber(SMSPlatform.dingshi, phone, contentType);
                if (map == null) {
                    message.put("msg", "验证码发送出现问题,请三分钟后再试");
                } else {
                    String code = map.get("randomCode").toString();
                    Subject subject = SecurityUtils.getSubject();
                    subject.getSession().setAttribute("sys.login.check.code", phone + code);
                    message.put("msg", "发送成功");
                }
            }
        } catch (Exception e) {
            logger.info("SMS==================验证码发送出现问题========" + phone + "======");
            message.put("msg", "验证码发送出现问题,请三分钟后再试");
        }
        return message;
    }

    @Log("用户注册")
    @PostMapping("/register")
    Map<String, String> register(String phone, String codenum) {
        Map<String, String> message = new HashMap<>();
        String msg = "";
        if (StringUtils.isBlank(phone)) {
            message.put("msg", "手机号码不能为空");
        } else {
            Subject subject = SecurityUtils.getSubject();
            Object object = subject.getSession().getAttribute("sys.login.check.code");
            if (object != null) {
                String captcha = object.toString();
                if (captcha == null || "".equals(captcha)) {
                    message.put("msg", "验证码已失效，请重新点击发送验证码");
                } else {
                    // session中存放的验证码是手机号+验证码
                    if (!captcha.equalsIgnoreCase(phone + codenum)) {
                        message.put("msg", "手机验证码错误");
                    } else {
                        Map<String, Object> mapP = new HashMap<String, Object>();
                        mapP.put("username", phone);
                        boolean flag = userService.exit(mapP);
                        if (flag) {
                            message.put("msg", "手机号码已存在");
                        } else {
                            OwnerUserDO udo = new OwnerUserDO();
                            udo.setUsername(phone);
                            udo.setPhone(phone);
                            udo.setPassword("123456");
                            udo.setNickname(phone);
                            udo.setBalance(0.00);
                            udo.setDeleteFlag(0);
                            udo.setRegisterTime(new Date());
                            if (userService.save(udo) > 0) {
                                message.put("msg", "注册成功");
                            } else {
                                message.put("msg", "注册失败");
                            }
                        }
                    }
                }
            } else {
                message.put("msg", "手机验证码错误");
            }
        }
        return message;
    }

    @Log("登录")
    @PostMapping("/login")
    Map<String, Object> login(String phone, String password, String codenum) {
        Map<String, Object> message = new HashMap<>();
        String msg = "";
        UsernamePasswordToken token = new UsernamePasswordToken(phone, password);
        Subject subject = SecurityUtils.getSubject();
        Object object = subject.getSession().getAttribute("sys.login.check.code");
        try {
            if (object != null) {
                String captcha = object.toString();
                if (captcha == null || "".equals(captcha)) {
                    message.put("msg", "验证码已失效，请重新点击发送验证码");
                } else {
                    // session中存放的验证码是手机号+验证码
                    if (!captcha.equalsIgnoreCase(phone + codenum)) {
                        message.put("msg", "手机验证码错误");
                    } else {
                        Map<String, Object> mapP = new HashMap<String, Object>();
                        mapP.put("username", phone);
                        boolean flag = userService.exit(mapP);
                        if (!flag) {
                            message.put("msg", "该手机号码未注册");
                        } else {
                            OwnerUserDO udo = userService.getbyname(phone);
                            if (udo.getDeleteFlag() == 1) {
                                message.put("msg", "禁止登录，请联系客服");
                            } else {
                                subject.login(token);
                                udo.setLoginTime(new Date());
                                userService.update(udo);
                                message.put("id", udo.getId());
                                message.put("nickname", udo.getNickname());
                                message.put("heardUrl", udo.getHeardUrl());
                                message.put("loginTime", udo.getLoginTime());
                                message.put("msg", "登录成功");
                            }
                        }
                    }
                }
            } else {
                message.put("msg", "手机验证码错误");
            }
        } catch (AuthenticationException e) {
            message.put("msg", "手机号或验证码错误");
        }
        return message;
    }

    @Log("登出")
    @GetMapping("/logout")
    Map<String, String> logout() {
        Map<String, String> message = new HashMap<>();
        ShiroUtils.logout();
        message.put("msg", "登出成功");
        return message;
    }

}
