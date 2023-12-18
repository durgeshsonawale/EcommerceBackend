package com.durgesh.ecommerce.service;

import com.durgesh.ecommerce.model.OrderProduct;
import com.durgesh.ecommerce.model.Orders;
import com.durgesh.ecommerce.model.Product;
import com.durgesh.ecommerce.model.User;
import com.durgesh.ecommerce.repo.IOrderProductRepo;
import com.durgesh.ecommerce.repo.IOrderRepo;
import com.durgesh.ecommerce.repo.IProductRepo;
import com.durgesh.ecommerce.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    IUserRepo iUserRepo;
    @Autowired
    IOrderRepo iOrderRepo;
    @Autowired
    IProductRepo iProductRepo;
    @Autowired
    IOrderProductRepo iOrderProductRepo;

    public String addOrder(int id){
        Orders order=new Orders();

        User user1=iUserRepo.findById(id).get();
        //System.out.println(id);

        order.setUser(user1);
       // System.out.println(order);
        List<Product> li=user1.getProducts();
        ArrayList<Integer> quant=new ArrayList<>();
        int cost=0;
        //System.out.println(li);
       for(Product p: li){
           order.getProducts().add(p);

           //OrderProduct op=new OrderProduct();
           cost+=p.getPrice()*p.getQuantity();
           quant.add(p.getQuantity());

           p.setAvailableQuant(p.getAvailableQuant()-p.getQuantity());
           p.setQuantity(1);
           iProductRepo.save(p);
       }
        //System.out.println(order);
        order.setPrize(cost);
       order.setTime(LocalDateTime.now());
        iOrderRepo.save(order);
        int orderId=order.getOrderId();
        int ind=0;
        for(Product p: order.getProducts()){

           OrderProduct a= iOrderProductRepo.findByOrderAndProduct(order,p);
           a.setQuantity(quant.get(ind));
           ind++;
           iOrderProductRepo.save(a);
        }
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
    public List<OrderProduct> getAllByOrder(int id){
        Orders order=iOrderRepo.findById(id).get();
        return iOrderProductRepo.findAllByOrder(order);
    }
}
