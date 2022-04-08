package cn.aokan.controller;

import cn.aokan.common.Result;
import cn.aokan.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/aokan")
public class PaymentController {
    @Resource
    PaymentService paymentService;

    @GetMapping(value = "/payment/get/{id}")
    public Result getById(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }
    @GetMapping(value = "/payment/get/error")
    public String getError(){
        return paymentService.getError();
    }
}
