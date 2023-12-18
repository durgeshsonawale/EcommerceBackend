package com.durgesh.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders_products")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orders_order_id")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "products_product_id")
    private Product product;
    @Column(nullable = false, columnDefinition = "int default 0")
    private int quantity;

}
