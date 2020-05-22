package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//ribbon 自定义负载均衡不能将该类与主启动类同包活包下,并要在主启动类上配置ribbonClient  @RibbonClient(name="cloud-provider-payment",configuration = MyRule.class)
@Configuration
public class MyRule {

    @Bean
    public IRule mySelfRule(){
        return  new RandomRule();
    }
}
