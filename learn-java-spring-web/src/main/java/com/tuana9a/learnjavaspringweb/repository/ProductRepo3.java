package com.tuana9a.learnjavaspringweb.repository;

import com.tuana9a.learnjavaspringweb.entities.Brand;
import com.tuana9a.learnjavaspringweb.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo3 extends JpaRepository<Product, Integer> {

    List<Product> findByNameIsLikeAndBrand(String name, Brand brand);

    List<Product> findByNameIsLikeAndBrand_Id(String name, Integer brandId);
}
