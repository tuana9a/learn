package com.tuana9a.learnjavaservlet.security;

import com.tuana9a.learnjavaservlet.configs.AppConfig;
import com.tuana9a.learnjavaservlet.utils.JwtUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/api/admin/*")
public class JwtCookieFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equalsIgnoreCase("token")) {
                    String jwtToken = cookie.getValue();
                    String secret = JwtUtils.getInstance().decodeToken(jwtToken);
                    if (AppConfig.getInstance().SECRETS.contains(secret)) {
                        chain.doFilter(request, response);
                        return;
                    }
                    break;
                }
            }
        }
        resp.sendError(HttpServletResponse.SC_FORBIDDEN);
    }

    @Override
    public void destroy() {
    }

}
