package com.zhiyu.pay.controller;

import cn.shuibo.annotation.Decrypt;
import cn.shuibo.annotation.Encrypt;
import com.alibaba.fastjson.JSON;
import com.zhiyu.pay.common.annotation.ratelimiter.RateLimiters;
import com.zhiyu.pay.entity.dto.PayDTO;
import com.zhiyu.pay.utils.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author wengzhiyu
 * @date 2020/11/16
 */
@RestController
@RequestMapping("/test")
@Api(tags = "测试模块")
public class TestController {


    @GetMapping("/encrypt")
    @ApiOperation("测试返回值加密")
    @Encrypt
    public PayDTO testEncrypt() {
        PayDTO payDTO=new PayDTO();
        payDTO.setSubject("我是subject");
        payDTO.setBody("我是body");
        return payDTO;
    }

    @Decrypt
    @PostMapping("/decryption")
    public String decryption(@RequestBody PayDTO payDTO){
        return JSON.toJSONString(payDTO);
    }

    @GetMapping("/var")
    @RateLimiters(value = 1.0,timeout = 100,timeUnit = TimeUnit.MILLISECONDS)
    public ResponseData test(String data){

        return  ResponseData.success(data);
    }
}
