package com.tuana9a.learnjavaspringweb.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "order_has_product")

@Getter
@Setter

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderHasProduct {

    @EmbeddedId
    private OrderHasProductKey key;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    @JsonSerialize(using = Order.SingleSerializer.class)
    private Order order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    @JsonSerialize(using = Product.SingleSerializer.class)
    private Product product;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "price")
    private Double price;
}
