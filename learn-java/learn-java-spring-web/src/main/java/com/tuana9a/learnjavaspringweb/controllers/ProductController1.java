package com.tuana9a.learnjavaspringweb.controllers;

import com.tuana9a.learnjavaspringweb.entities.Product;
import com.tuana9a.learnjavaspringweb.repository.ProductRepo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/products")
public class ProductController1 {

    @Autowired
    private ProductRepo1 repo;

    @PostMapping
    public void persist(@RequestBody Product object) {
        repo.insert(object);
    }

    @GetMapping
    public Object find(@RequestParam(name = "which") String which,
                       @RequestParam(name = "name", required = false) String name,
                       @RequestParam(name = "value", required = false) String value) {
        Object result;
        switch (which) {
            case "count-all":
                result = repo.countAll();
                break;
            case "custom-count-all":
                result = repo.customCountAll();
                break;
            case "count-group-by-brand":
                result = repo.countGroupByBrand();
                break;
            case "by":
                result = repo.findBy(name, value);
                break;
            default:
                result = repo.findAll();
                break;
        }
        return result;
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Long id) {
        return repo.findById(id);
    }

    @PutMapping("/{id}")
    public void merge(@RequestBody Product object) {
        repo.update(object);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Long id) {
        repo.delete(id);
    }

}
