package com.durgesh.ecommerce.repo;

import com.durgesh.ecommerce.model.OrderProduct;
import com.durgesh.ecommerce.model.Orders;
import com.durgesh.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderProductRepo extends JpaRepository<OrderProduct,Long> {
    OrderProduct findByOrderAndProduct(Orders order, Product product);
    List<OrderProduct> findAllByOrder(Orders order);
}
