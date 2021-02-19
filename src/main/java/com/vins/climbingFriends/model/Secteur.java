package com.vins.climbingFriends.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Secteur implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    private String localisation;

    private String acces;


}
