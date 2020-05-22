package com.atguigu.controller;


import com.atguigu.service.PaymentFignService;
import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderOpenFeignController {

    @Autowired
    PaymentFignService paymentFignService;

    @GetMapping(value="comsumer/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return paymentFignService.getPaymentById(id);
    }
}
