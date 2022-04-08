package cn.aokan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class CloudProviderHystrixPayment8001Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderHystrixPayment8001Application.class, args);
    }
}
