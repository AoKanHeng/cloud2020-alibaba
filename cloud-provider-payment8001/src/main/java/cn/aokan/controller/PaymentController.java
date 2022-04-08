package cn.aokan.controller;

import cn.aokan.common.Result;

import cn.aokan.pojo.enetiy.Payment;
import cn.aokan.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api("cloud2020的api！")
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    @ApiOperation(value = "保存")
    public Result create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);
        if (result > 0) {
            return Result.buildResult(200, "插入成功！");
        } else {
            return Result.buildResult(999, "插入数据失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public Result getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getByIdPayment(id);
        if (payment != null) {
            return Result.buildResult(200, "查询成功,对应的ip" + serverPort, payment);
        } else {
            return Result.buildResult(444, "没有对应记录,查询ID：" + id, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object getDiscoveryClient() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println("-----------" + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance element1 : instances) {
            System.out.println("!!!!!!!!!!!!!!!" + element1);
        }
        return this.discoveryClient;
    }

}
