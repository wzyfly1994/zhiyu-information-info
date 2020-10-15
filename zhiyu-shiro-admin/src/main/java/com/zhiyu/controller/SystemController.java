package com.zhiyu.controller;

import com.zhiyu.entity.dto.SystemUserDto;
import com.zhiyu.service.SystemPermissionService;
import com.zhiyu.service.SystemService;
import com.zhiyu.utils.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;


/**
 * @author wengzhiyu
 * @date 2020/1/06
 */
@RestController
@RequestMapping("/system")
@Api(tags = "系统模块")
public class SystemController {

    @Resource
    private SystemService systemService;
    @Resource
    private SystemPermissionService systemPermissionService;
    @Autowired
    @Lazy
    private ShiroFilterFactoryBean shiroFilterFactoryBean;


    @PostMapping("/login")
    @ApiOperation("登陆")
    public ResponseData login(@RequestBody @Valid SystemUserDto systemUserDto) {
        return systemService.userLogin(systemUserDto);
    }


    @PostMapping("/signIn")
    @ApiOperation("注册")
    public ResponseData signIn(@RequestBody @Valid SystemUserDto systemUserDto) {
        return systemService.signIn(systemUserDto);
    }

    @GetMapping("/permission/update")
    public ResponseData updatePermission() {
        return ResponseData.success(systemPermissionService.updateFilterChain());
    }

    @GetMapping("/loginError")
    public ResponseData error() {
        return ResponseData.error("用户未授权");
    }

}
