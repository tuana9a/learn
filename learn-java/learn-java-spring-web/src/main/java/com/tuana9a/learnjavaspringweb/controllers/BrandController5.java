package com.tuana9a.learnjavaspringweb.controllers;

import com.tuana9a.learnjavaspringweb.entities.Brand;
import com.tuana9a.learnjavaspringweb.services.BrandService5;
import com.tuana9a.learnjavaspringweb.utils.JsonResponseUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v5/brands")
public class BrandController5 extends BaseController5<Brand> {
    public BrandController5(BrandService5 brandService5, JsonResponseUtils jsonResponseUtils) {
        super(brandService5, jsonResponseUtils);
    }
}
