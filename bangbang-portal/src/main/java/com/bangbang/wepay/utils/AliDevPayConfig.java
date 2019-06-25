package com.bangbang.wepay.utils;

/**
 * 支付宝下单基本参数
 */
public class AliDevPayConfig {
	/**
     * 1.商户appid
     */
    public static final String APP_ID="2019031763576290";
 
    /**
     * 私钥 pkcs8格式的
     */
    public static final String RSA_PRIVATE_KEY="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCaNYx49CYGyY9ziQN8lDi3QwYT7SoukKYzScbxCAqybQZUMoJh3RgDvwPHx2ErAydwDBCzPv/mrx9m/uTZoVMBr/OlfZc/5yINPxAowqbC/OPJE3Eo6WGkU25COg25F/wZjMNwc5vG/6utRuptBsKxpNKrvvR2pIP8scKM4FqG6rI8X8hhCFQ0DgvGan8Hl44W9aAhfXs64b0QWnHdNkgr2p4Vh+LrXMjnscEEI+VhWsxq3eFAOdLIrm4ObgRPVgAL3jZ3MvvPCnAIgP644JOTigJ4elQwOZBOMyk0AFJloYrkIQu55ENiEafBrzGXQj+lw1BK7aC9jbd7lxdBIX6xAgMBAAECggEALwZfVM8W/YDfltrUTlwgw3nT06XB9Ds2A3PfD8dlA64NfQV+DvvOA+5u57AcKHKoxxlWymJOxPjoOY9HGDqCxoPyZ6fZxKnmD2YItnVNRy65A6tDGbe5h9PNTrLHVodC4EO1oYgPm+qBXrC+cgraujNJ7wenIrreaOOIMU+FK5jSqFUcBqvb5IkTI/Y+42QO6wI0jnUGEtd9zovhoQnUjr5W+i70dqHI6XtFqsyMdMkgGq7aFbyKtFGjfKWHQZ8cXTrrW03gmen+GFC4UHa00GkaK7xp/3XpkAAm6nunkxV0ibZHhnaxlxdPiZk3jD2tv8JEJwsiHvkI73ymz90dtQKBgQDYuHqYCG1ljhnavVW6SCu0+vo1qEeF5qMZwUm0vc7AVWSbKGKeBXRrsnC1bX1bGfzilRna95p4qvPpzZB37QhsiDlzpn8EEbQMgMzXuSQ/8+ro6vDKp0vUfUcx7rvrAulU4P9ocPpK5kE7vwedsukkXpyNSg5SLvsRg/QGF5MsQwKBgQC2KKE6svc0lWrGM+/nh816nKpzs2JzvGsAiWQ6wqToGDbJatWVyIGmUmTBrRcYS2uIDIcApxkdT4pujN1YO/JE//HDzHkLdM1GTrQN+r1ZDaTu/RawkT5EccnXmNr65D/8H5wH1Kn5IHugh+qE0m/1gnWuz75o4Rpn3BN0Z5Fz+wKBgFQ2SxzsmWXO8+j1jWxXQvSOWc+j1jcHyfTmELf00XQXOoK4DKoOwJBgxD8bjoxp6sQ439UgRZwCAcmmIS8Yoh9aR8jSt6RjJK1/Fxn0TUu0gmGDeZGltGebTqDufYLynKxoyZZR4FBebJbEwjbbIJELWpXkYvA4ZUMHHTmIy511AoGAHjDRuBbdXfu9vKfzBR6+8alxnseGc8Qwv+AFmq+UAVuyCOQKDk8zHcveIzN69m3Znqzk2zjWssLyIKx8KxmUZ9c7zMXg8gMj2plEwmRiaZYXVfzge9c2yMVLPM56zMZzzGe4xpt6qG23z713Ixh1se0zcAvCdUOJytjw6IQZ2W0CgYEA0id/d8FRYm66lvpxXNBjRpXKgz4so1wiZSwF7bz0jYldUHzMldEn1YdDg1USblIqOlArt9m+d9Ag5xBLSfc6ZuWgvrKRc9NxDCmiuVFKN8b39O8s329JaFQz5XCJ3TCdgfnjtXzjzBvTPGKVrNU9eDOvKplzCjYMK012POUqjr8=";
 
    /**
     * 3.支付宝公钥
     */
    public static final String ALIPAY_PUBLIC_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn1GyRM4Lr2DnkXN6e540LV1ybN04eVnJGUnU71ZEaAcZHLO01OeKvqQM8g4twr0nqllS/2+vbMpRmCs7eY2nX8VMsbc0kUcMFTOt+7IZ0ZeJAzY/v7/G2f7KwQv0V76tiUcZw5gxYq8S/AvtBl6g+f4AUYt6GHqfn3XO2Q1yGYGoOsR70gcWPXDmzlezgtJhkBfX1kSeG7st09FqCY4Utb+5gWBlDyFS9riCWP8etyKhiHIqs5sN7IKzXXbscfeJGcI+4BZ7/0FL32aNnkA2rT0hyimI4CsewqYJaB94ghKn+3DNVP9JTI5Jts1cGlUwQ27fZb9LBGj7BGk6ZIWgQwIDAQAB";
 
  
    public static final String NOTIFY_URL = "https://nmgshiguangji.com/aliNotify";
 
    
 
    /**
     * 正式环境支付宝网关，如果是沙箱环境需更改成https://openapi.alipaydev.com/gateway.do
     */
    public static final String URL = "https://openapi.alipaydev.com/gateway.do";
 
    /**
     * 7.编码
     */
    public static final String CHARSET = "UTF-8";
 
    /**
     * 私钥 pkcs8格式的
     */
    // 8.返回格式
    public static final String FORMAT = "json";
 
    /**
     * //签名方式 加密类型
     */
    public static final String SIGNTYPE = "RSA2";

}
