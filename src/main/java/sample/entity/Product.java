package sample.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int productId;
    @Column(name = "product_name",unique = true, nullable=false)
    private String productName;
    @Column(name = "price",nullable = false)
    private double price;
    @Column(name = "quantity",nullable = false)
    private int quantity;
}
