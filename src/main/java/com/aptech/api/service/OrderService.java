package com.aptech.api.service;

import com.aptech.api.dto.OrderDto;
import com.aptech.api.entity.OrderDetails;
import com.aptech.api.entity.Orders;
import com.aptech.api.repository.OderDetailsRepository;
import com.aptech.api.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OderDetailsRepository oderDetailsRepository;

    @Autowired
    private ProductService productService;

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public Orders getOrderById(int id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));
    }

//    public Orders createOrder(Orders order) {
//        return orderRepository.save(order);
//    }

//    public Orders createOrder(List<OrderDto> orderDtos) {
//        Orders orders = orderRepository.save(new Orders());
//        for (OrderDto dto: orderDtos){
//            OrderDetails.builder()
//                    .quantity(dto.getQuantity())
//                    .product(productService.get(dto.getIdProduct()))
//                    .price(productService.get(dto.getIdProduct()).getPrice())
//                    .orders(orders)
//                    .build();
////            ord
////        }
//
//        return Orders.builder()
//                .phone(order.getPhone())
//                .address(order.getAddress())
//                .build()
//
//
//
//
//
//        return orderRepository.save(order);
//    }

//    public Order updateOrder(Long id, Order order) {
//        Order existingOrder = getOrderById(id);
//        existingOrder.setCustomerName(order.getCustomerName());
//        existingOrder.setAddress(order.getAddress());
//        existingOrder.setTotalAmount(order.getTotalAmount());
//        return orderRepository.save(existingOrder);
//    }

    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
