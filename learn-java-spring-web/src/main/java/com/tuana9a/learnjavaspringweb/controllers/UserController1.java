package com.tuana9a.learnjavaspringweb.controllers;

import com.tuana9a.learnjavaspringweb.entities.User;
import com.tuana9a.learnjavaspringweb.dto.JsonResponse;
import com.tuana9a.learnjavaspringweb.repository.UserRepo1;
import com.tuana9a.learnjavaspringweb.utils.JsonResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController1 {

    @Autowired
    private UserRepo1 repo;

    @Autowired
    private JsonResponseUtils responseUtils;

    @PostMapping
    public ResponseEntity<JsonResponse> persist(@RequestBody User object) {
        repo.persist(object);
        return responseUtils.created(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JsonResponse> findById(@PathVariable("id") Long id) {
        User result = repo.findById(id);
        return responseUtils.ok(result);
    }

    @PutMapping
    public ResponseEntity<JsonResponse> merge(@RequestBody User object) {
        User result = repo.merge(object);
        return responseUtils.updated(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JsonResponse> remove(@PathVariable("id") Long id) {
        repo.remove(id);
        return responseUtils.deleted();
    }

}
