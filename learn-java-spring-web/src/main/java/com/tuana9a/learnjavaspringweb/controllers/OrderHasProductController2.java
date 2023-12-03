package com.tuana9a.learnjavaspringweb.controllers;

import com.tuana9a.learnjavaspringweb.entities.Order;
import com.tuana9a.learnjavaspringweb.entities.OrderHasProduct;
import com.tuana9a.learnjavaspringweb.entities.Product;
import com.tuana9a.learnjavaspringweb.entities.User;
import com.tuana9a.learnjavaspringweb.entities.OrderHasProductKey;
import com.tuana9a.learnjavaspringweb.repository.OrderHasProductRepo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/order-has-product")
public class OrderHasProductController2 {

    @Autowired
    private OrderHasProductRepo2 repo;

    @PostMapping
    public void save(@RequestBody OrderHasProduct orderHasProduct) {
        repo.save(orderHasProduct);
    }

    @GetMapping
    public Optional<OrderHasProduct> findById(@RequestParam("orderId") Long orderId,
                                              @RequestParam("productId") Long productId) {
        return repo.findById(new OrderHasProductKey(orderId, productId));
    }


    @GetMapping("/order/{id}")
    public List<OrderHasProduct> findByOrderId(@PathVariable("id") Long id) {
        OrderHasProduct key = OrderHasProduct.builder()
                .key(new OrderHasProductKey(id, null))
                .build();
        Example<OrderHasProduct> example = Example.of(key);
        return repo.findAll(example);
    }

    @GetMapping("/order/user")
    public List<OrderHasProduct> findByOrderUserName(@RequestParam("name") String name) {
        User user = new User();
        user.setName(name);

        Order order = new Order();
        order.setUser(user);

        OrderHasProduct orderHasProduct = new OrderHasProduct();
        orderHasProduct.setOrder(order);

        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<OrderHasProduct> example = Example.of(orderHasProduct, exampleMatcher);
        return repo.findAll(example);
    }

    @GetMapping("/order/user/{id}")
    public List<OrderHasProduct> findByOrderUserId(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);

        Order order = new Order();
        order.setUser(user);

        OrderHasProduct orderHasProduct = new OrderHasProduct();
        orderHasProduct.setOrder(order);

        Example<OrderHasProduct> example = Example.of(orderHasProduct);
        return repo.findAll(example);
    }


    @GetMapping("/product/{id}")
    public List<OrderHasProduct> findByProductId(@PathVariable("id") Long id) {
        OrderHasProductKey orderHasProductKey = new OrderHasProductKey();
        orderHasProductKey.setProductId(id);

        OrderHasProduct orderHasProduct = new OrderHasProduct();
        orderHasProduct.setKey(orderHasProductKey);

        Example<OrderHasProduct> example = Example.of(orderHasProduct);
        return repo.findAll(example);
    }

    @GetMapping("/product/name")
    public List<OrderHasProduct> findByProductName(@RequestParam("name") String name) {
        Product product = new Product();
        product.setName(name);

        OrderHasProduct orderHasProduct = new OrderHasProduct();
        orderHasProduct.setProduct(product);

        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<OrderHasProduct> example = Example.of(orderHasProduct, exampleMatcher);
        return repo.findAll(example);
    }
}