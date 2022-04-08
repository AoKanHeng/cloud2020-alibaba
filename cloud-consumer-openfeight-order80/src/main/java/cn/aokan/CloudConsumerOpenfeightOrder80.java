package cn.aokan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CloudConsumerOpenfeightOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOpenfeightOrder80.class,args);
    }
}
