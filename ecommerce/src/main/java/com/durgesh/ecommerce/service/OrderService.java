package com.durgesh.ecommerce.service;

import com.durgesh.ecommerce.model.Orders;
import com.durgesh.ecommerce.model.Product;
import com.durgesh.ecommerce.model.User;
import com.durgesh.ecommerce.repo.IOrderRepo;
import com.durgesh.ecommerce.repo.IProductRepo;
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
    @Autowired
    IProductRepo iProductRepo;

    public String addOrder(int id){
        Orders order=new Orders();

        User user1=iUserRepo.findById(id).get();
        //System.out.println(id);

        order.setUser(user1);
       // System.out.println(order);
        List<Product> li=user1.getProducts();
        int cost=0;
        //System.out.println(li);
       for(Product p: li){
//           DummyProduct Dproduct=new DummyProduct(p.getProductId(),p.getQuantity());
//           idProduct.save(Dproduct);
//
//           order.getDproducts().add(Dproduct);
           order.getProducts().add(p);
           cost+=p.getPrice()*p.getQuantity();
           p.setQuantity(0);
           iProductRepo.save(p);
       }
        //System.out.println(order);
        order.setPrize(cost);
        iOrderRepo.save(order);
        user1.getProducts().removeAll(user1.getProducts());
        iUserRepo.save(user1);


        return "order created succesfully";

    }

    public List<Orders> getOrders() {

        return iOrderRepo.findAll();
    }

    public String setStatus(int id, String status) {
        Orders order=iOrderRepo.findById(id).get();
        order.setStatus(status);
        iOrderRepo.save(order);
        return "Order status updated";
    }
    public Orders getOrderById(int id){
        return iOrderRepo.findById(id).get();
    }
    public List<Orders> getByUser(int id){
        User user=iUserRepo.findById(id).get();
        return iOrderRepo.findByUser(user);
    }
}
