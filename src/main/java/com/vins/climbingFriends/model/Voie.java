package com.vins.climbingFriends.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Voie implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private int cotation;

    @ManyToOne
    Secteur secteur;

    @OneToMany
    Collection<Longueur> longueurs;
}
