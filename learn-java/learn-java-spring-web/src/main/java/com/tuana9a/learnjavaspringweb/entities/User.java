package com.tuana9a.learnjavaspringweb.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")

@Getter
@Setter
@Builder

@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "google_id")
    private String googleId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "deleted")
    private Boolean deleted;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private Address address;
}
