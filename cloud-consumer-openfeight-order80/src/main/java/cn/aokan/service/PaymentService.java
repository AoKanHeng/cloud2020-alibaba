package cn.aokan.service;

import cn.aokan.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "CLOUD-PROVIDER-SERVICE")
public interface PaymentService {

    @GetMapping(value = "/payment/get/{id}")
    Result getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/get/error")
    String getError();
}
