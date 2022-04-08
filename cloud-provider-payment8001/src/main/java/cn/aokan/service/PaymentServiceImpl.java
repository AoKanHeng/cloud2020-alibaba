package cn.aokan.service;

import cn.aokan.dao.PaymentDao;
import cn.aokan.pojo.enetiy.Payment;
import cn.aokan.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.savePayment(payment);
    }

    @Override
    public Payment getByIdPayment(Long id) {
        return paymentDao.getByIdPayment(id);
    }
}
