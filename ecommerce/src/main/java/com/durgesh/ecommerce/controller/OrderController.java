package com.durgesh.ecommerce.controller;

import com.durgesh.ecommerce.model.Orders;
import com.durgesh.ecommerce.model.User;
import com.durgesh.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping()
    public String addOrders(@RequestBody User user){
        return orderService.addOrder(user);
    }
    @GetMapping()
    public List<Orders> getOrder(){
        return orderService.getOrder();
    }

}
