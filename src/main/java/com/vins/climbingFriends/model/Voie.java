package com.vins.climbingFriends.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Voie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "[0-6][ABC]")
    private String cotation;

    @ManyToOne
    Secteur secteur;

    @OneToMany
    Collection<Longueur> longueurs;
}
