package cn.aokan.controller;

import cn.aokan.common.Result;
import cn.aokan.pojo.enetiy.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderController {

    private static final String PAYMENT_URL = "http://CLOUD-PROVIDER-SERVICE/";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/save")
    public Result<Payment> savePayment(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "payment/create", payment, Result.class);
    }

    @GetMapping("/get/{id}")
    public Result<Payment> getById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "payment/get/" + id, Result.class);
    }

    @GetMapping("/get/eneity/{id}")
    public Result<Payment> getByIdEneity(@PathVariable("id") Long id) {
        ResponseEntity<Result> forEntity = restTemplate.getForEntity(PAYMENT_URL + "payment/get/" + id, Result.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println(forEntity.getHeaders());
            return forEntity.getBody();
        } else {
            return Result.buildResult(444, "错误！！！");
        }
    }
}
