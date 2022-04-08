package cn.aokan.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Service
 @FeignClient(name = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface PaymentHystrixService {


    @GetMapping("a1/aokan/get/ok/{id}")
    String get_OK(@PathVariable("id") String id);

    @GetMapping("a1/aokan/get/error/{id}")
    String get_EOOR(@PathVariable("id") String id);

}
