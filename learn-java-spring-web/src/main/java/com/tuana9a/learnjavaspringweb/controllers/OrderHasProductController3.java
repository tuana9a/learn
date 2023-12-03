package com.tuana9a.learnjavaspringweb.controllers;

import com.tuana9a.learnjavaspringweb.entities.OrderHasProduct;
import com.tuana9a.learnjavaspringweb.repository.OrderHasProductRepo3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/order-has-product")
public class OrderHasProductController3 {

    @Autowired
    private OrderHasProductRepo3 repo;

    @GetMapping("/order/{id}")
    public List<OrderHasProduct> findByOrderId(@PathVariable("id") Long id) {
        return repo.findByOrder_Id(id);
    }

    @GetMapping("/order/user/name")
    public List<OrderHasProduct> findByOrderUserName(@RequestParam("name") String name) {
        return repo.findByOrder_User_NameContains(name);
    }

    @GetMapping("/order/user/{id}")
    public List<OrderHasProduct> findByOrderUserId(@PathVariable("id") Long id) {
        return repo.findByOrder_User_Id(id);
    }

    @GetMapping("/product/{id}")
    public List<OrderHasProduct> findByProductId(@PathVariable("id") Long id) {
        return repo.findByKey_ProductId(id);
    }

    @GetMapping("/product/name")
    public List<OrderHasProduct> findByProductName(@RequestParam("name") String name) {
        return repo.findByProduct_NameContains(name);
    }

}