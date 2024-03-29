package com.bangbang.owneruser.controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.bangbang.common.annotation.Log;
import com.bangbang.common.controller.BaseController;
import com.bangbang.common.utils.ShiroUtils;
import com.bangbang.information.domain.SubscriberDO;
import com.bangbang.information.service.SubscriberService;
import com.bangbang.owneruser.comment.GenerateCode;
import com.bangbang.owneruser.comment.SMSContent;
import com.bangbang.owneruser.comment.SMSPlatform;
import com.bangbang.owneruser.comment.SMSTemplate;
import com.bangbang.owneruser.domain.OwnerUserDO;
import com.bangbang.owneruser.service.OwnerUserService;
import com.bangbang.smsservice.service.ISMSService;


@RestController
public class LoginController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

   
    @Autowired
    OwnerUserService userService;
    @Autowired
    private ISMSService sMSService;
    @Autowired
	private SubscriberService subscriberService;
   
    @Log("密码登录")  
	@PostMapping("/loginP")
    Map<String, Object> loginP(String phone, String password) {
 	    Map<String, Object> message = new HashMap<>();
	   	UsernamePasswordToken token = new UsernamePasswordToken(phone, password);
	   	Subject subject = SecurityUtils.getSubject();
	   		try {
	   			Map<String, Object> mapP = new HashMap<String, Object>();
	   			mapP.put("username", phone);
	   			boolean flag = userService.exit(mapP);
	   			if (!flag) {
	   				message.put("msg","该手机号码未注册");
	   			}
	   			OwnerUserDO udo= userService.getbyname(phone);
	   			if(udo.getDeleteFlag()==0){
	   				message.put("msg","禁止登录，请联系客服");
	   			}
	   			subject.login(token);
	   			udo.setLoginTime(new Date());
	   			userService.update(udo);
	   			
                message.put("id", udo.getId());
                message.put("nickname", udo.getNickname());
                message.put("heardUrl", udo.getHeardUrl());
                message.put("loginTime", udo.getLoginTime());
	   			message.put("msg","登录成功");
	   		} catch (AuthenticationException e) {
	   			message.put("msg","用户或密码错误");
	   		}
	    	return message;
    }
   
   /* @Log("发送验证码")
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
                
                Map<String, Object> map = sMSService.sendCodeNumber(SMSPlatform.bangbang, phone, contentType);
                if (map == null) {
                    message.put("msg", "验证码发送出现问题,请三分钟后再试");
                } else {
	                String code = map.get("randomCode").toString();
	                Subject subject = SecurityUtils.getSubject();
	                subject.getSession().setAttribute("sys.login.check.code", phone + code);
	                message.put("msg", "发送成功");
	                message.put("sessionId",subject.getSession().getId().toString());
               }
            }
        } catch (Exception e) {
            logger.info("SMS==================验证码发送出现问题========" + phone + "======");
            message.put("code", "1");
            message.put("msg", "验证码发送出现问题,请三分钟后再试");
        }
        return message;
    }*/
    
    /*
    pom.xml
    <dependency>
      <groupId>com.aliyun</groupId>
      <artifactId>aliyun-java-sdk-core</artifactId>
      <version>4.0.3</version>
    </dependency>
    */
    
    /**
     * @param phone 手机号
     * @param type  类型 0：注册   1：登录	2：密码重置
     * @说明 发送验证码
     */
    @Log("发送验证码")
	@PostMapping("/captcha")
       static Map<String, String> getSms(String phone,String type){
    		Map<String, String> message = new HashMap<>();
    		
    		try { 
    			if (phone == null || "".equals(phone)) {
	                message.put("msg", "手机号码不能为空");
	            }else {
	            	DefaultProfile profile = DefaultProfile.getProfile("default", "LTAI8vH63loOPvE8", "Cg5DIuEkqYjIJ1dYoU7FNsMapAPNtz");
		            IAcsClient client = new DefaultAcsClient(profile);
		            
		            Integer templateParam = (int)((Math.random()*9+1)*100000);
		            System.out.println("============验证码===================="+templateParam);
		            
		            CommonRequest request = new CommonRequest();
		            //request.setProtocol(ProtocolType.HTTPS);
		            request.setMethod(MethodType.POST);
		            request.setDomain("dysmsapi.aliyuncs.com");
		            request.setVersion("2017-05-25");
		            request.setAction("SendSms");
		             
		            request.putQueryParameter("PhoneNumbers", phone);
		           
		            request.putQueryParameter("SignName", "时光机");
		            if ("0".equals(type)) {
		            	request.putQueryParameter("TemplateCode", "SMS_166315791");
	                }else if ("1".equals(type)) {			//登陆
	                	 request.putQueryParameter("TemplateCode", "SMS_166315793");
	                }else if ("2".equals(type)){			//重置密码
	                	request.putQueryParameter("TemplateCode", "SMS_166315790");
	                }
		           
		            request.putQueryParameter("TemplateParam",  "{\"code\":\""+templateParam+"\"}");
	            
	            
	                CommonResponse response = client.getCommonResponse(request);
	                
	                Subject subject = SecurityUtils.getSubject();
	                subject.getSession().setAttribute("sys.login.check.code", phone + templateParam);
	                message.put("msg", "发送成功");
	                message.put("sessionId",subject.getSession().getId().toString());
	            } 
            } catch (ServerException e) {
                e.printStackTrace();
            } catch (ClientException e) {
                e.printStackTrace();
            }
            return message;
    } 
    
    
	   @Log("验证码登录")
	   @PostMapping("/loginC")
	    Map<String, Object> loginC(String phone, String codenum) {
	        Map<String, Object> message = new HashMap<>();
	        Map<String, Object> map = new HashMap<>();
	        String msg = "";
	        Subject subject = SecurityUtils.getSubject();
	        
	        Object object = subject.getSession().getAttribute("sys.login.check.code");
	        try {
	            if (object != null) {
	           
	                String captcha = object.toString();
	                if (captcha == null || "".equals(captcha)) {
	                	message.put("code", 1);
	                    message.put("msg", "验证码已失效，请重新点击发送验证码");
	                } else {
	                    // session中存放的验证码是手机号+验证码
	                    if (!captcha.equalsIgnoreCase(phone+codenum)) {
	                    	message.put("code", 1);
	                        message.put("msg", "手机验证码错误");
	                    } else {
	                        Map<String, Object> mapP = new HashMap<String, Object>();
	                        mapP.put("username", phone);
	                        boolean flag = userService.exit(mapP);
	                        if (!flag) {
	                            //message.put("msg", "该手机号码未注册");
	                            OwnerUserDO udo = new OwnerUserDO();
	                            Long userId = GenerateCode.gen16(8);
	                            udo.setUserId(userId);
	                            udo.setUsername(phone);
	                            udo.setPhone(phone);
	                            udo.setDeleteFlag(0);
	                            udo.setRegisterTime(new Date());
	                            userService.save(udo);
	                            
	                            OwnerUserDO udos = userService.getbyname(phone);
	                            if (udos==null||udos.getDeleteFlag() == 1) {
	                                message.put("msg", "禁止登录，请联系客服");
	                            } else {
	                            	
	                            //	String password = udos.getPassword();
	                            //	System.out.println("==================="+password+"========================");
	                            	UsernamePasswordToken token = new UsernamePasswordToken(phone, codenum);
	                            	subject.login(token);
	                            	
	                            	udos.setLoginTime(new Date());
	                                
	                                userService.update(udos);
	                                SubscriberDO info = subscriberService.getInfo(phone);
	                               // map.put("id", udos.getId());
	                               // map.put("nickname", udos.getNickname());
	                              //  map.put("heardUrl", udos.getHeardUrl());
	                               // map.put("loginTime", udos.getLoginTime());
	                                message.put("code", 0);
	                                message.put("msg", "登录成功");
	                                message.put("data", info);
	                                
	                            	
	                            }
	                        } else {
	                            OwnerUserDO udo = userService.getbyname(phone);
	                            if (udo==null||udo.getDeleteFlag() == 1) {
	                                message.put("msg", "禁止登录，请联系客服");
	                            } else {
	                            	
	                            //	String password = udo.getPassword();
	                           // 	System.out.println("==================="+password+"========================");
	                            	UsernamePasswordToken token = new UsernamePasswordToken(phone, codenum);
	                            	subject.login(token);
	                            	
	                                udo.setLoginTime(new Date());
	                                
	                                userService.update(udo);
	                                SubscriberDO info = subscriberService.getInfo(phone);
	                               // map.put("id", udo.getId());
	                               // map.put("nickname", udo.getNickname());
	                               // map.put("heardUrl", udo.getHeardUrl());
	                               // map.put("loginTime", udo.getLoginTime());
	                                message.put("code", 0);
	                                message.put("msg", "登录成功");
	                                message.put("data", info);
	                             
	                            }
	                        }
	                    }
	                }
	            } else {
	            	message.put("code", 1);
	                message.put("msg", "手机验证码错误");
	            }
	        } catch (AuthenticationException e) {
	        	message.put("code", 1);
	            message.put("msg", "手机号或验证码错误");
	        }
	        return message;
	    }

 

    @Log("用户注册")
    @PostMapping("/register")
    Map<String, String> register(String phone, String codenum,String password) {
        Map<String, String> message = new HashMap<>();
        String msg = "";
        if (StringUtils.isBlank(phone)) {
            message.put("msg", "手机号码不能为空");
        } else {
            Subject subject = SecurityUtils.getSubject();
            Object object = subject.getSession().getAttribute("sys.login.check.code");
            if (object != null) {
            	String captcha = object.toString();
            	//String captcha = "666666";
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
                            Long userId = GenerateCode.gen16(8);
                            udo.setUserId(userId);
                            udo.setUsername(phone);
                            udo.setPhone(phone);
                            udo.setPassword(password);
                            udo.setDeleteFlag(1);
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
    
    @Log("忘记密码")
	@PostMapping("/retpwd")
    Map<String, String> retpwd(String username, String password,  String codenum) {
        Map<String, String> message = new HashMap<>();
		if (StringUtils.isBlank(username)) {
			message.put("msg","手机号码不能为空");
		}else{
			OwnerUserDO udo= userService.getbyname(username);
			Subject subject = SecurityUtils.getSubject();
			Object object =subject.getSession().getAttribute("sys.login.check.code");
			if (object != null) {
	            String captcha = object.toString();
	            if (captcha == null || "".equals(captcha)) {
	                message.put("msg", "验证码已失效，请重新点击发送验证码");
	            } else {
	                // session中存放的验证码是手机号+验证码
	                if (!captcha.equalsIgnoreCase(username + codenum)) {
	                    message.put("msg", "手机验证码错误");
	                } else {
	                    Map<String, Object> mapP = new HashMap<String, Object>();
	                    mapP.put("username", username);
	                    boolean flag = userService.exit(mapP);
	                    if (!flag) {
	                        message.put("msg", "该手机号码未注册");
	                    }else{
	                    	udo.setPassword(password);
	            			if (userService.update(udo) > 0) {
	            				message.put("msg","修改成功");
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
    
    @Log("登出")
    @GetMapping("/logout")
    Map<String, String> logout() {
        Map<String, String> message = new HashMap<>();
        ShiroUtils.logout();
        message.put("msg", "登出成功");
        return message;
    }

}
