package com.tuana9a.learnjavaspringweb.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.tuana9a.learnjavaspringweb.config.AppConfig;
import com.tuana9a.learnjavaspringweb.entities.User;
import com.tuana9a.learnjavaspringweb.dto.JsonResponse;
import com.tuana9a.learnjavaspringweb.repository.UserRepo3;
import com.tuana9a.learnjavaspringweb.services.GoogleService;
import com.tuana9a.learnjavaspringweb.services.JwtService;
import com.tuana9a.learnjavaspringweb.utils.JsonResponseUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class OAuthGoogleController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private GoogleService googleService;

    @Autowired
    private UserRepo3 userRepo;

    @Autowired
    private AppConfig config;

    @Autowired
    private JsonResponseUtils jsonResponseUtils;

    @GetMapping("/google/login")
    public String login() {
        return "redirect:" + googleService.createAuthorizationURL();
    }

    @GetMapping("/google/callback")
    public ResponseEntity<JsonResponse> callback(@RequestParam(name = "code") String code, HttpServletResponse resp) throws Exception {
        String accessToken = null;
        try {
            accessToken = googleService.createAccessToken(code);
        } catch (Exception ignored) {
        }

        if(accessToken == null) {
            return jsonResponseUtils.badRequest("invalid request");
        }
        
        User googleUser = googleService.getUserInfoByToken(accessToken);
        String username = googleUser.getUsername();
        User existUser = userRepo.findByUsernameAndDeletedFalse(username);
        User result;
        if (existUser == null) {
            googleUser.setId(System.currentTimeMillis());
            result = userRepo.save(googleUser);
        } else {
            existUser.setGoogleId(googleUser.getGoogleId());
            existUser.setName(googleUser.getName());
            result = userRepo.save(existUser);
        }
        Cookie cookie = new Cookie(config.JWT_TOKEN_NAME, jwtService.generateToken(username));
        resp.addCookie(cookie);
        return jsonResponseUtils.ok(result);
    }

}
