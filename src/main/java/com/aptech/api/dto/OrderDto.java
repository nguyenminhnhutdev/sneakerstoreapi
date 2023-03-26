package com.aptech.api.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrderDto {
    private int idProduct;
    private int quantity;
    private int idUser;
    private String address;
    private String phone;

}
