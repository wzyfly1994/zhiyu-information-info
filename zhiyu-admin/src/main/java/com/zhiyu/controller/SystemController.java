package com.zhiyu.controller;

import com.zhiyu.entity.system.dto.SystemUserDto;
import com.zhiyu.service.system.AboutUserService;
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


    @GetMapping("httpTest")
    public void httpTest(HttpServletRequest request) {
        String seesionId = request.getSession().getId();
        System.out.println("seesionId++" + seesionId);
        System.out.println("action++" + request.getSession().getAttribute("wowo"));
    }

    @GetMapping("set")
    public void httpSet(HttpServletRequest request) {
        request.getSession().setAttribute("wowo", "12345");
    }


    @GetMapping("/loginError")
    public ResponseData error() {
        return ResponseData.error("用户未授权");
    }

}
