package com.zhiyu.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wengzhiyu
 * @date 2020/11/12
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class ZhiyuPayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhiyuPayServiceApplication.class, args);
    }

}
