package com.atguigu.controller;


import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

//    private static final String PAYMENT_URL = "http://localhost:8001";
   private static final String PAYMENT_URL = "http://cloud-provider-payment";


    @Autowired
    RestTemplate restTemplate;
    
    @GetMapping(value = "/comsumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        CommonResult commonResult = restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        return  commonResult;
    }

    @GetMapping(value = "/comsumer/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        CommonResult commonResult = restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById/"+id, CommonResult.class);
        return  commonResult;
    }

    @GetMapping(value = "/comsumer/payment/createPaymentEntity")
    public CommonResult<Payment> createPaymentEntity(Payment payment){
        ResponseEntity<CommonResult> commonResultResponseEntity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        if (commonResultResponseEntity.getStatusCode().is2xxSuccessful()){
            return  commonResultResponseEntity.getBody();
        }else{
            return  new CommonResult<Payment>(404,"操作失败");
        }

    }

    @GetMapping(value = "/comsumer/payment/getPaymentEntityById/{id}")
    public CommonResult<Payment> getPaymentEntityById(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> commonResultResponseEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/getPaymentById/"+id, CommonResult.class);
        if (commonResultResponseEntity.getStatusCode().is2xxSuccessful()){
            return  commonResultResponseEntity.getBody();
        }else{
            return  new CommonResult<Payment>(404,"操作失败");
        }
    }

}
