package com.durgesh.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private Type category;
    private int price;
    private String description;
    private String imageUrl;
    private int rating;

    private int quantity=1;
    private int availableQuant=100;
//    @OneToMany
//    private List<Quantity> quantities;
    @JsonIgnore
    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<User> users;
    //private String review;
}
