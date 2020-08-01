package com.zhiyu.config.constant;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author wengzhiyu
 * @date 2020/01/07
 */
public class Constants {

    /**
     * header字段
     */
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    @Value("${custom.jwt.secret-key}")
    public  void setJwtSecretKey(String jwtSecretKey) {
        JWT_SECRET_KEY = jwtSecretKey;
    }

    /**
     * SECRET
     */
    public static  String JWT_SECRET_KEY ;

    /**
     * 后台登录令牌
     */
    public static final String LOGIN_TOKEN = "login_token:";

    /**
     * 后台登录用户
     */
    public static final String LOGIN_USER = "login_user";

    /**
     * 返回登录令牌
     */
    public static final String TOKEN = "token";


    /**
     * session 过期时间
     */
    public static final Long SESSION_TIMEOUT = 60L;




}
