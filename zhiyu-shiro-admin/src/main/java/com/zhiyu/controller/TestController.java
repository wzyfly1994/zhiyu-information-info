package com.zhiyu.controller;

import com.zhiyu.config.constant.Constants;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wengzhiyu
 * @date 2020/10/15
 */
@RestController
@RequestMapping("/test")
@Api(tags = "测试模块")
public class TestController {

    @GetMapping("/setRedis/{value}")
    public String setRedis(@PathVariable String value, HttpServletRequest httpServletRequest) {
        String result;
        try {
            httpServletRequest.getSession().setAttribute("my_redis_session", value);
            result = "redis设置成功";
        } catch (Exception e) {
            result = "redis设置失败:" + e.getMessage();
        }
        return result;
    }


    @GetMapping("/getRedis/{value}")
    public String getRedis(@PathVariable String value, HttpServletRequest httpServletRequest) {
        String result;
        try {
            result = "redis读取成功:" + httpServletRequest.getSession().getAttribute(Constants.LOGIN_TOKEN + value);
            System.out.println(result);
        } catch (Exception e) {
            result = "redis读取失败:" + e.getMessage();
        }
        return result;
    }
}
