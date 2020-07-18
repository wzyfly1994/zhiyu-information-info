package com.zhiyu.controller;

import com.zhiyu.entity.system.dto.SystemUserDto;
import com.zhiyu.service.system.AboutUserService;
import com.zhiyu.util.RedisUtil;
import com.zhiyu.util.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


/**
 * @author wengzhiyu
 * @date 2020/1/06
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户模块")
public class SystemController {

    @Resource
    private AboutUserService aboutUserService;
    @Resource
    private RedisUtil redisUtil;



    @PostMapping("/login")
    @ApiOperation("登陆")
    public ResponseData login(@RequestBody @Valid SystemUserDto systemUserDto) {
        return aboutUserService.userLogin(systemUserDto);
    }


    @PostMapping("/signIn")
    @ApiOperation("注册")
    public ResponseData signIn(@RequestBody @Valid SystemUserDto systemUserDto) {
        return aboutUserService.signIn(systemUserDto);
    }


    @GetMapping("/setRedis/{value}")
    public String setRedis(@PathVariable String value, HttpServletRequest httpServletRequest) {
        String result;
        try {
            redisUtil.set("redis_key", value);
            httpServletRequest.getSession().setAttribute("my_redis_session", value);
            result = "redis设置成功";
        } catch (Exception e) {
            result = "redis设置失败:" + e.getMessage();
        }
        return result;
    }


    @GetMapping("/getRedis")
    public String getRedis(HttpServletRequest httpServletRequest) {
        String result;
        try {
            String value = (String) redisUtil.get("sessionAttr:login_token");
            result = "redis读取成功:" + value+"---id=="+httpServletRequest.getSession().getId();
            String myRedisSession = (String) httpServletRequest.getSession().getAttribute("sessionAttr:login_token:"+httpServletRequest.getSession().getId());
            System.out.println(myRedisSession);
        } catch (Exception e) {
            result = "redis读取失败:" + e.getMessage();
        }
        return result;
    }


    @GetMapping("/loginError")
    public ResponseData error() {
        return ResponseData.error("用户未授权");
    }

}
