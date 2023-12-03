package com.tuana9a.learnjavaspringweb.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginForm {
    private String username;
    private String password;
}
