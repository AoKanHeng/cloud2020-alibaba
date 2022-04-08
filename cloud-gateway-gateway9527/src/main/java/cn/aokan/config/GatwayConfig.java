package cn.aokan.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatwayConfig {
    @Bean
    public RouteLocator configRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_rote_aokan",r->r.path("/guonei").uri("https://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
