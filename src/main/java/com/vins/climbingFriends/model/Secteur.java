package com.vins.climbingFriends.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Secteur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String localisation;

    private String acces;

    @ManyToOne
    SiteEscalade siteEscalade;

    @OneToMany
    Collection<Voie> voies;


}
