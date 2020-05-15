package com.zhiyu.gateway.config.swagger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.support.NameUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * @author wengzhiyu
 * @time 2020/4/19 16:42
 * @description
 */
@Component
@Primary
@Slf4j
public class SwaggerProvider  implements SwaggerResourcesProvider {

    public static final String API_URI = "/v2/api-docs";

    @Resource(name = "customRouteLocator")
    private RouteLocator customRouteLocator;

    @Resource
    private GatewayProperties gatewayProperties;



    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        //取出gateway的route
        Flux<Route> flux=customRouteLocator.getRoutes();
        flux.subscribe(route ->
                new ArrayList<>(8).add(route.getId()));
        //结合配置的route-路径(Path)，和route过滤，只获取有效的route节点
        gatewayProperties.getRoutes()
                .forEach(routeDefinition -> routeDefinition.getPredicates()
                        .forEach(predicateDefinition -> resources.add(
                                swaggerResource(routeDefinition.getId(),
                                        predicateDefinition.getArgs().get(NameUtils.GENERATED_NAME_PREFIX + "0")
                                        .replace("/**", API_URI)))));

        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }

}