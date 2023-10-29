package com.tuana9a.learnjavaspringweb.controllers;

import com.tuana9a.learnjavaspringweb.entities.Order;
import com.tuana9a.learnjavaspringweb.repository.OrderRepo2;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v2/orders")

@AllArgsConstructor
public class OrderController2 {

    private final OrderRepo2 repo;

    @PostMapping
    public void save(@RequestBody Order order) {
        repo.save(order);
    }

    @GetMapping
    public Object find(@RequestParam(value = "sort", required = false) String sort,
                       @RequestParam(value = "sortField", required = false) String sortField,
                       @RequestParam(value = "isPage", required = false) Boolean isPage,
                       Pageable pageable,
                       @RequestParam(value = "pageIndex", required = false) Integer pageIndex,
                       @RequestParam(value = "pageLength", required = false) Integer pageLength) {
        Object result = null;
        Sort _sort = Sort.by(Sort.Direction.ASC, sortField);
        if (sort != null && sort.equals("desc")) {
            _sort = Sort.by(Sort.Direction.DESC, sortField);
        }

        if (isPage != null && isPage) {
            if (pageable != null) {
                result = repo.findAll(pageable);
            } else if (pageIndex != null) {
                Pageable _pageable = PageRequest.of(pageIndex, pageLength, _sort);
                Example<Order> deletedFalse = Example.of(Order.builder().deleted(false).build());
                return repo.findAll(deletedFalse, _pageable);
            }
        } else {
            result = repo.findAll(_sort);
        }
        return result;
    }

    @GetMapping("/{id}")
    public Optional<Order> findById(@PathVariable("id") Long id) {
        return repo.findById(id);
    }
}
