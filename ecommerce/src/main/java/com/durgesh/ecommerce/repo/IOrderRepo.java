package com.durgesh.ecommerce.repo;

import com.durgesh.ecommerce.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepo extends JpaRepository<Orders,Integer> {
}
