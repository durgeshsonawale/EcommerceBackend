package com.durgesh.ecommerce.controller;

import com.durgesh.ecommerce.model.OrderProduct;
import com.durgesh.ecommerce.repo.IOrderProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orderproduct")
public class OrderProductController {
    @Autowired
    IOrderProductRepo iOrderProductRepo;


}
