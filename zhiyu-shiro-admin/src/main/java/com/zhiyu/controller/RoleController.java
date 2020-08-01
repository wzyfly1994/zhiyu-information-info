package com.zhiyu.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wengzhiyu
 * @date 2020/5/26
 */
@RestController
@RequestMapping("role")
@Api(tags = "角色模块")
public class RoleController {

    @GetMapping("/welcome")
    public String welcome(HttpServletRequest request, HttpServletResponse response) {
        return "welcome";
    }

}
