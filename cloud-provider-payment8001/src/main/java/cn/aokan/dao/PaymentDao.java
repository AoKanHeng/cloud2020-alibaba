package cn.aokan.dao;

import cn.aokan.pojo.enetiy.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {

    int savePayment(Payment payment);

    Payment getByIdPayment(Long id);
}
