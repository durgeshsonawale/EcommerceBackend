package com.durgesh.ecommerce.service;

import com.durgesh.ecommerce.model.Product;
import com.durgesh.ecommerce.model.Type;
import com.durgesh.ecommerce.repo.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    IProductRepo iProductRepo;

    public Product getProductById(int id) {
        Product product= iProductRepo.findById(id).get();
        return product;
    }

    public List<Product> getAllProducts() {
        List<Product> productList=iProductRepo.findAll();
        return productList;
    }

    public List<Product> getAllByCategory(Type category) {
        List<Product> productList=iProductRepo.findByCategory(category);
        return productList;
    }

    public String deleteById(int id) {
        iProductRepo.deleteById(id);
        return "Deleted Succesfully";
    }

    public String createProduct(Product product) {
        iProductRepo.save(product);
        return "product added succesfully";
    }

    public String updateById(Product product) {
        Product product1=iProductRepo.findById(product.getProductId()).get();
        iProductRepo.save(product);
        return "product updated succesfully";


    }
}
