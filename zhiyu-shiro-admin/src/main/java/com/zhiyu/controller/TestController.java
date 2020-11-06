package com.zhiyu.controller;

import com.alibaba.fastjson.JSON;
import com.zhiyu.config.constant.Constants;
import com.zhiyu.utils.RedisUtil;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author wengzhiyu
 * @date 2020/10/15
 */
@RestController
@RequestMapping("/test")
@Api(tags = "测试模块")
public class TestController {

    @Resource
    private RedisUtil redisUtil;

    @GetMapping("/setSession/{value}")
    public String setSession(@PathVariable String value, HttpServletRequest httpServletRequest) {
        String result;
        try {
            httpServletRequest.getSession().setAttribute("my_redis_session", value);
            result = "Session设置成功";
        } catch (Exception e) {
            result = "Session设置失败:" + e.getMessage();
        }
        return result;
    }


    @GetMapping("/getSession/{value}")
    public String getSession(@PathVariable String value, HttpServletRequest httpServletRequest) {
        String result;
        try {
            result = "Session读取成功:" + httpServletRequest.getSession().getAttribute(Constants.LOGIN_TOKEN + value);
        } catch (Exception e) {
            result = "Session读取失败:" + e.getMessage();
        }
        return result;
    }


    @GetMapping("/getRedis/{value}")
    public String getRedis(@PathVariable String value) {
        String result;
        try {
            String username = (String) SecurityUtils.getSubject().getPrincipal();
            result = "redis读取成功:" + JSON.toJSONString(redisUtil.get(username));
        } catch (Exception e) {
            result = "redis读取失败:" + e.getMessage();
        }
        return result;
    }


    @GetMapping("/getSubjectSession/{value}")
    public String getSubjectSession(@PathVariable String value) {
        String result;
        try {
            result = "SubjectSession:" + SecurityUtils.getSubject().getSession().getAttribute(Constants.LOGIN_USER + value);
        } catch (Exception e) {
            result = "SubjectSession读取失败:" + e.getMessage();
        }
        return result;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
