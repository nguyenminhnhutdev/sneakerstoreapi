package com.aptech.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stt;
    private int quantity;
    private double price;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Orders orders;
//    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "product_id")
//    private List<Product> products;

//    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "order_id")
//    private List<Orders> orders;
}
