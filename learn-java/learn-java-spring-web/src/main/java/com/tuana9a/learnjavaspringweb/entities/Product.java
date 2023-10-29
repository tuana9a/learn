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
@Table(name = "product")

@Getter
@Setter

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "image")
    private String image;

    @Column(name = "introduction")
    private String introduction;

    @Column(name = "created")
    private Long created;

    @Column(name = "deleted")
    private Boolean deleted;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "order_has_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    @JsonSerialize(using = Order.ListSerializer.class)
    private List<Order> orders;

    public static class SingleSerializer extends JsonSerializer<Product> {
        @Override
        public void serialize(Product product, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeObject(Product.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .quantity(product.getQuantity())
                    .image(product.getImage())
                    .introduction(product.getIntroduction())
                    .created(product.getCreated())
                    .deleted(product.getDeleted())
                    .brand(product.getBrand())
                    .build());
        }

    }

    public static class ListSerializer extends JsonSerializer<List<Product>> {
        @Override
        public void serialize(List<Product> products, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            List<Product> result = new ArrayList<>();
            products.forEach(product -> result.add(Product.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .quantity(product.getQuantity())
                    .image(product.getImage())
                    .introduction(product.getIntroduction())
                    .created(product.getCreated())
                    .deleted(product.getDeleted())
                    .brand(product.getBrand())
                    .build()));
            jsonGenerator.writeObject(result);
        }

    }

}
