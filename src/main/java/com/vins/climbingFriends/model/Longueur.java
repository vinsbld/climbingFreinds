package com.vins.climbingFriends.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Longueur implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private int distance;

    private int hauteur;

    @ManyToOne
    Voie voie;


}
