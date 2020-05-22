package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        Logger logger = Logger.getLogger(String.valueOf(PaymentController.class));
        logger.info("*********插入结果："+result);
        System.out.println("sss");
        if (result>0){
            return new CommonResult(200,"插入成功,serverPort: "+serverPort,result);
        }else{
            return new CommonResult(200,"插入失败",null);
        }

    }

    @GetMapping(value="/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        Logger logger = Logger.getLogger(String.valueOf(PaymentController.class));
        logger.info("*********查询结果："+result);
        if (result!=null){
            return new CommonResult(200,"查询成功,serverPort: "+serverPort,result);
        }else{
            return new CommonResult(200,"查询失败",null);
        }

    }

    @GetMapping(value="/payment/get/{id}")
    public String get(@PathVariable("id") Long id){
        return  this.serverPort;
    }
}