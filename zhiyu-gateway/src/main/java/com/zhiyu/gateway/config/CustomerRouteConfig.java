package com.zhiyu.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wengzhiyu
 * @time 2020/4/19 16:42
 * @description 自定义路由配置
 */
@Configuration
public class CustomerRouteConfig {


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // 公共服务组件
                .route(r -> r.path("/shiro-admin/**")
                        .uri("lb://shiro-admin/")
                )
                .build();
    }


}
