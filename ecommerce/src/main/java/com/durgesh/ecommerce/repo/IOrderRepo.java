package com.durgesh.ecommerce.repo;

import com.durgesh.ecommerce.model.Orders;
import com.durgesh.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepo extends JpaRepository<Orders,Integer> {
    List<Orders> findByUser(User user);
}
