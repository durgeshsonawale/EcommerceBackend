package com.durgesh.ecommerce.controller;

import com.durgesh.ecommerce.model.Product;
import com.durgesh.ecommerce.model.Type;
import com.durgesh.ecommerce.service.ProductService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("{id}")
    public Product getProductById(@PathVariable int id){
        return this.productService.getProductById(id);
    }
    @GetMapping("products")
    public List<Product> getAllProducts(){
        return this.productService.getAllProducts();
    }
    @GetMapping("products/{category}")
    public List<Product> getAllByCategory(@PathVariable Type category){
        return this.productService.getAllByCategory(category);

    }
    @DeleteMapping("{id}")
    @CrossOrigin("*")
    public String deleteById(@PathVariable int id){
        return this.productService.deleteById(id);
    }
    @PostMapping()
    public String createProduct(@RequestBody Product product){
        return this.productService.createProduct(product);
    }

    @PutMapping()
    public String updateById(@RequestBody Product product){
        return this.productService.updateById(product);
    }




}
