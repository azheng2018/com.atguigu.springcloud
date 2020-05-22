//package com.atguigu.springcloud.filter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.Date;
//import java.util.logging.Logger;
//
///**
// * 全局自定义过滤器
// *
// * @author zzyy
// * @version 1.0
// * @create 2020/03/06
// */
//@Component
//@Slf4j
//public class MyLogGatewayFilter implements GlobalFilter, Ordered {
//
//    Logger logger = Logger.getLogger(String.valueOf(MyLogGatewayFilter.class));
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        logger.info("come in global filter: {}");
//
//        ServerHttpRequest request = exchange.getRequest();
//        String uname = request.getQueryParams().getFirst("uname");
//        if (uname == null) {
//            logger.info("用户名为null，非法用户");
//            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
//            return exchange.getResponse().setComplete();
//        }
//        // 放行
//        return chain.filter(exchange);
//    }
//
//    /**
//     * 过滤器加载的顺序 越小,优先级别越高
//     *
//     * @return
//     */
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}