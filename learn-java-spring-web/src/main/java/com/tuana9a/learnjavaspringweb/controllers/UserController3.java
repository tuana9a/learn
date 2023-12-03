package com.tuana9a.learnjavaspringweb.controllers;

import com.tuana9a.learnjavaspringweb.config.AppConfig;
import com.tuana9a.learnjavaspringweb.entities.User;
import com.tuana9a.learnjavaspringweb.dto.LoginForm;
import com.tuana9a.learnjavaspringweb.dto.RegisterForm;
import com.tuana9a.learnjavaspringweb.repository.UserRepo3;
import com.tuana9a.learnjavaspringweb.services.JwtService;
import com.tuana9a.learnjavaspringweb.utils.EncodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api/v3/users")
public class UserController3 {
    @Autowired
    private UserRepo3 repo;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private EncodeUtils encodeUtils;

    @Autowired
    private AppConfig config;

    @GetMapping("/exist")
    public ResponseEntity<Object> exist(@RequestParam("username") String username) {
        Object result = repo.existsByUsernameAndDeletedFalse(username);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginForm form, HttpServletResponse resp) {
        String username = form.getUsername();
        String hashedPassword = encodeUtils.getSHA256(form.getPassword());
        Object result = false;

        boolean exist = repo.existsByUsernameAndPasswordAndDeletedFalse(username, hashedPassword);
        if (exist) {
            Cookie cookie = new Cookie(config.JWT_TOKEN_NAME, jwtService.generateToken(form.getUsername()));
            resp.addCookie(cookie);
            result = true;
        }

        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/register")
    public Object register(@RequestBody RegisterForm form) {
        Object result = false;
        boolean exist = repo.existsByUsernameAndDeletedFalse(form.getUsername());
        if (exist) return result;

        result = true;
        User user = User.builder()
                .username(form.getUsername())
                .password(encodeUtils.getSHA256(form.getPassword()))
                .name(form.getName())
                .deleted(false)
                .build();
        repo.save(user);

        return result;
    }
}
