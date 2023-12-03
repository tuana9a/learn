package com.tuana9a.learnjavaspringweb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// có thể đặt ở trước class hoặc ở tên phương thức
@RequestMapping("/api/redirect")
public class RedirectController {
    @RequestMapping(value = "/here", method = RequestMethod.GET)
    public String here() {
        return "/here.html";
    }
}
