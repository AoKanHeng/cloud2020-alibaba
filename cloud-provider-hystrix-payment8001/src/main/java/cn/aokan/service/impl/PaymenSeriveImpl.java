package cn.aokan.service.impl;

import cn.aokan.service.PaymenSerive;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymenSeriveImpl implements PaymenSerive {
    @Override
    public String get_OK(String id) {
        return "当前" + Thread.currentThread().getName() + "：get_OK-》" + id + ";😄！！！";
    }

    @Override
    //失败
    @HystrixCommand(fallbackMethod = "redayedAll",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")  //3秒钟以内就是正常的业务逻辑
    })
    public String get_EOOR(String id) {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "当前" + Thread.currentThread().getName() + "：get_EOOR-》" + id + ";🙅！！！‍";

    }

    public String redayedAll(String id){
        return "当前" + Thread.currentThread().getName() + "：get_EOOR-》" + id + ";当前系统繁忙，请稍候再试！";

    }
}
