package com.tuana9a.learnjavaspringweb.config;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@ToString
public class AppConfig {

    public Integer CODE_OK = 1;
    public Integer CODE_NOT_OK = 0;

    @Value("${custom.name}")
    public String CUSTOM_NAME;

    @Value("${custom.root_folder}")
    public String ROOT_FOLDER;

    public String JWT_TOKEN_NAME = "token";

    @Value("${custom.jwt.secret}")
    public String JWT_SECRET;

    @Value("${custom.jwt.expiration_time}")
    public Long JWT_EXPIRATION_TIME;

    @Value(("${custom.jwt.prefix}"))
    public String JWT_PREFIX;

}
