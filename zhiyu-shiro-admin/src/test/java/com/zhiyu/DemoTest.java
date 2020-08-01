package com.zhiyu;

import com.zhiyu.config.constant.Constants;

/**
 * @author wengzhiyu
 * @date 2020/1/11
 */
public class DemoTest {


    public static void main(String[] args) {
//
//        System.out.println(TimeUnit.MINUTES.toSeconds(30));
//        System.out.println(TimeUnit.DAYS.toHours(1));

//        Claims claims= JwtUtil.getClaims("eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1OTYwOTYwMjksImlhdCI6MTU5NjA4ODgyOSwiYWNjb3VudCI6Ind6eTMzNiIsInRpbWVzdGFtcCI6MTU5NjA4ODgyOTI3NX0.JgPTWLTRp8NuSUcDOdhV7l6Z3G6e8AZczkExpqL_7I5GHntQB1EjiYLjHvcDfF4IhjoUinuEX_j5iDkRvGXSGQ");
//        System.out.println(claims);
//        String account= (String) claims.get("account");
//        System.out.println(account);
        System.out.println(Constants.JWT_SECRET_KEY);
    }
}
