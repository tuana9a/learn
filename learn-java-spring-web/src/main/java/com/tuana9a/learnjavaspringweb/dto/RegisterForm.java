package com.tuana9a.learnjavaspringweb.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterForm {
    private String username;
    private String password;
    private String name;
}
