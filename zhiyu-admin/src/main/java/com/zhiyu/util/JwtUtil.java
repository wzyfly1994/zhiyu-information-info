package com.zhiyu.util;

import com.alibaba.fastjson.JSONObject;
import com.zhiyu.config.constant.Constants;
import io.jsonwebtoken.*;

import java.util.Date;
import java.util.Map;


/**
 * JWT工具
 *
 * @author wzy
 * @date 2019/11/1
 */
public class JwtUtil {

    private static Date getExpireTime() {
        return new Date(System.currentTimeMillis() + 7200000L);
    }

    public static String getToken(Map<String, Object> claims) {
        return Jwts.builder().setClaims(claims)
                //签发时间
                .setIssuedAt(new Date())
                //过期时间
                .setExpiration(getExpireTime())
                .signWith(SignatureAlgorithm.HS512, Constants.JWT_SECRET)
                .compact();
    }

    public static JSONObject validateToken(String token) {
        JSONObject jsonObject = new JSONObject();
        boolean code = true;
        String msg = "";
        try {
            Claims body = Jwts.parser().setSigningKey(Constants.JWT_SECRET).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            // token已过期
            code = false;
            msg = "token已过期，请重新登录";
        } catch (UnsupportedJwtException e) {
            // token不支持
            code = false;
            msg = "token信息不能被解析，请重新登录";
        } catch (MalformedJwtException e) {
            // token格式不对
            code = false;
            msg = "token格式错误，请重新登录";
        } catch (SignatureException e) {
            // token签名不对
            code = false;
            msg = "token签名错误，请重新登录";
        } catch (IllegalArgumentException e) {
            // token格式转换错误
            code = false;
            msg = "token为空，请重新登录";
        }

        jsonObject.put("code", code);
        jsonObject.put("msg", msg);
        return jsonObject;
    }

    public static Claims getClaims(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(Constants.JWT_SECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            // token错误
            e.printStackTrace();
        }
        return claims;
    }

}
