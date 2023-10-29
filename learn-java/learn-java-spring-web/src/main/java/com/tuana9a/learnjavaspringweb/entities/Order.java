package com.tuana9a.learnjavaspringweb.entities;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orderr") // order is a keyword in SQL syntax

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "created")
    private Long created;

    @Column(name = "total_money")
    private Double totalMoney;

    @Column(name = "deleted")
    private Boolean deleted;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "order_has_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    @JsonSerialize(using = Product.ListSerializer.class)
    private List<Product> products;

    public static class SingleSerializer extends JsonSerializer<Order> {
        @Override
        public void serialize(Order order, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

            jsonGenerator.writeObject(Order.builder()
                    .id(order.getId())
                    .created(order.getCreated())
                    .totalMoney(order.getTotalMoney())
                    .deleted(order.getDeleted())
                    .user(order.getUser())
                    .build());
        }
    }

    public static class ListSerializer extends JsonSerializer<List<Order>> {
        @Override
        public void serialize(List<Order> orders, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            List<Order> result = new ArrayList<>();
            orders.forEach(bill -> result.add(Order.builder()
                    .id(bill.getId())
                    .created(bill.getCreated())
                    .totalMoney(bill.getTotalMoney())
                    .deleted(bill.getDeleted())
                    .user(bill.getUser())
                    .build()));
            // EXPLAIN: bỏ .products(bill.getProducts()) vì cho vô là loop
            jsonGenerator.writeObject(result);
        }

    }
}
