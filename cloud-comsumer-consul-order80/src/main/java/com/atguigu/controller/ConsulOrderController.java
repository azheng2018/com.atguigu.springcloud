package com.atguigu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsulOrderController {

   private static final String PAYMENT_URL = "http://consul-provider-payment";


    @Autowired
    RestTemplate restTemplate;
    
    @GetMapping(value = "/comsumer/payment/consul")
    public String create(){
        String commonResult = restTemplate.getForObject(PAYMENT_URL + "/payment/consul",String.class);
        return  commonResult;
    }


}
