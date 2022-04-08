package cn.aokan.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PaymentDto implements Serializable {

    private Long id;
    private String serial;
}
