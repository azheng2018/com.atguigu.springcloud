package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableCircuitBreaker
//服务降级和熔断使用EnableCircuitBreaker
public class PaymentHystrixMain8001 {
        public static void main(String[] args) {
            SpringApplication.run(PaymentHystrixMain8001.class, args);
        }
}
