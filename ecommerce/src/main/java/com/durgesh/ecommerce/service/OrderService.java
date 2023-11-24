package com.durgesh.ecommerce.service;

import com.durgesh.ecommerce.model.Orders;
import com.durgesh.ecommerce.model.Product;
import com.durgesh.ecommerce.model.User;
import com.durgesh.ecommerce.repo.IOrderRepo;
import com.durgesh.ecommerce.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    IUserRepo iUserRepo;
    @Autowired
    IOrderRepo iOrderRepo;

    public String addOrder(User user){
        Orders order=new Orders();
        int id= user.getUserId();
        User user1=iUserRepo.findById(id).get();
        //System.out.println(id);

        order.setUser(user1);
       // System.out.println(order);
        List<Product> li=user1.getProducts();
        //System.out.println(li);
       for(Product p: li){
           order.getProducts().add(p);
       }
        //System.out.println(order);
        iOrderRepo.save(order);
        user1.getProducts().removeAll(user1.getProducts());
        iUserRepo.save(user1);


        return "order created succesfully";

    }

    public List<Orders> getOrder(int id) {

        return iOrderRepo.findAllById()
    }
}
