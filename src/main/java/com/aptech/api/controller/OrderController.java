package com.aptech.api.controller;

import com.aptech.api.dto.OrderDto;
import com.aptech.api.entity.Orders;
import com.aptech.api.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Orders> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/get")
    public Orders getOrderById(@RequestParam(name = "id") int id) {
        return orderService.getOrderById(id);
    }

//    @PostMapping
//    public Orders createOrder(@RequestBody Orders order) {
//        return orderService.createOrder(order);
//    }
//    @PostMapping("/add")`
//    public Orders createOrder(@RequestBody List<OrderDto> ordersDto) {
//        return orderService.createOrder(ordersDto);
//    }`

//    @PutMapping("/update")
//    public Order updateOrder(@RequestParam(name = "id") int id, @RequestBody Order order) {
//        return orderService.updateOrder(id, order);
//    }
}
