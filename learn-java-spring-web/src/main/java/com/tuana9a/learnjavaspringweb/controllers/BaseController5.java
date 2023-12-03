package com.tuana9a.learnjavaspringweb.controllers;

import com.tuana9a.learnjavaspringweb.services.BaseService5;
import com.tuana9a.learnjavaspringweb.dto.JsonResponse;
import com.tuana9a.learnjavaspringweb.utils.JsonResponseUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public abstract class BaseController5<T> {
    private final BaseService5<T> service;
    private final JsonResponseUtils jsonResponseUtils;

    public BaseController5(BaseService5<T> service, JsonResponseUtils jsonResponseUtils) {
        this.service = service;
        this.jsonResponseUtils = jsonResponseUtils;
    }

    @GetMapping()
    public ResponseEntity<JsonResponse> search(
            @RequestParam(value = "queries", required = false) List<String> queries,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "isPageable") Boolean isPageable,
            Pageable pageable) throws Exception {

        Object result = isPageable ?
                service.filter(queries, pageable, sort) :
                service.filter(queries, sort);

        return jsonResponseUtils.ok(result);
    }
}
