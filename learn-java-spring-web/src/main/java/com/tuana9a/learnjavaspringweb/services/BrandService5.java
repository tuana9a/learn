package com.tuana9a.learnjavaspringweb.services;

import com.tuana9a.learnjavaspringweb.entities.Brand;
import com.tuana9a.learnjavaspringweb.repository.BrandRepo5;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class BrandService5 extends BaseService5<Brand> {
    public BrandService5(BrandRepo5 repo, EntityManager entityManager) {
        super(repo, Brand.class, entityManager);
    }
}
