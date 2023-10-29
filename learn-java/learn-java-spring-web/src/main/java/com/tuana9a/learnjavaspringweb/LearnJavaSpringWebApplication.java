package com.tuana9a.learnjavaspringweb;

import com.tuana9a.learnjavaspringweb.config.AppConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;


@Log4j2
@org.springframework.boot.autoconfigure.SpringBootApplication
public class LearnJavaSpringWebApplication implements CommandLineRunner {

    @Autowired
    private AppConfig config;

    public static void main(String[] args) {
        SpringApplication.run(LearnJavaSpringWebApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info(config);
    }
}