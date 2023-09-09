package com.example.jpa.chapter5;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;

@Entity
public class Chapter5OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    private Integer orderPrice;
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Chapter5Order order;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Chapter5Item item;

}