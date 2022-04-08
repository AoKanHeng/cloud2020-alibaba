package cn.aokan.service;

import cn.aokan.pojo.enetiy.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    public int create(Payment payment);

    public Payment getByIdPayment(@Param("id") Long id);
}
