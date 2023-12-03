package com.tuana9a.learnjavaspringweb.security;

import com.tuana9a.learnjavaspringweb.repository.UserRepo3;
import com.tuana9a.learnjavaspringweb.services.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserRepo3 userRepo;
    private final JwtService jwtService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.csrf().disable(); //disable hack cookie của người dùng và gửi request
    }

    @Bean
    public FilterRegistrationBean<GeneralFilter> generalFilter() {
        FilterRegistrationBean<GeneralFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new GeneralFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilter() {
        FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JwtFilter(userRepo, jwtService));
        registrationBean.addUrlPatterns("/api/admin/*", "/api/private/*");
        return registrationBean;
    }


}
