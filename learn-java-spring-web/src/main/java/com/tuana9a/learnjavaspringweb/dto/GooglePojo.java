package com.tuana9a.learnjavaspringweb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class GooglePojo {
    private String id;
    private String email;
    private String verified_email;
    private String name;
    private String given_name;
    private String family_name;
    private String picture;
    private String locale;
}
