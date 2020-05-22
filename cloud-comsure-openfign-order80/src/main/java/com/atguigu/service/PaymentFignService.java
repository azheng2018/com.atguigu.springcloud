package com.atguigu.service;

import com.atguigu.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//因为openfeign是个组件，所以要加component
@Component
@FeignClient(value = "cloud-provider-payment")
public interface PaymentFignService {

    @GetMapping(value="/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);
}
