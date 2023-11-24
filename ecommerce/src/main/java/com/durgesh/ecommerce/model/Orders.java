package com.durgesh.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Integer orderId;
    @ManyToOne
     private User user;
    @ManyToMany
      private List<Product> products=new ArrayList<>();
    private int prize;
}
