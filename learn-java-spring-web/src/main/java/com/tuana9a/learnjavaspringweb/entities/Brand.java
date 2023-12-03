package com.tuana9a.learnjavaspringweb.entities;


import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "brand")

@Getter
@Setter

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "deleted")
    private Boolean deleted;
}
