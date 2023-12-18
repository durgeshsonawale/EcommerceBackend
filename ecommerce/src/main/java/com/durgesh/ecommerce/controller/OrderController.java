package com.durgesh.ecommerce.controller;

import com.durgesh.ecommerce.model.OrderProduct;
import com.durgesh.ecommerce.model.Orders;
import com.durgesh.ecommerce.model.User;
import com.durgesh.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
//@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("{id}")
    public String addOrders(@PathVariable int id){
        return orderService.addOrder(id);
    }
    @GetMapping()
    public List<Orders> getOrders(){
        return orderService.getOrders();
    }
    @PutMapping("{id}/{status}")
    public String setStatus(@PathVariable int id,@PathVariable String status){
        return this.orderService.setStatus(id,status);
    }


    @GetMapping("{id}")
    Orders getOrderById(@PathVariable int id){
        return orderService.getOrderById(id);
    }

    @GetMapping("orders/{userId}")
    List<Orders> getAllOrders(@PathVariable int userId){
        return orderService.getByUser(userId);
    }
    @GetMapping("orderproduct/{id}")
    List<OrderProduct> getAllByOrder(@PathVariable int id){
        return this.orderService.getAllByOrder(id);
    }

}
