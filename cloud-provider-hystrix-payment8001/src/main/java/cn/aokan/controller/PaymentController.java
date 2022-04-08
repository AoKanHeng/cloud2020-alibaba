package cn.aokan.controller;

import cn.aokan.service.PaymenSerive;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("a1/aokan/")
public class PaymentController {

    @Resource
    private PaymenSerive paymenSerive;

    @GetMapping("get/ok/{id}")
    public String get_OK(@PathVariable("id") String id) {
        return paymenSerive.get_OK(id);
    }

    @GetMapping("get/error/{id}")
    public String get_EOOR(@PathVariable("id") String id) {
        return paymenSerive.get_EOOR(id);
    }

}
