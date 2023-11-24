package com.durgesh.ecommerce.repo;

import com.durgesh.ecommerce.model.Product;
import com.durgesh.ecommerce.model.Type;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepo extends JpaRepository<Product,Integer> {
    List<Product> findByCategory(Type category);
}
