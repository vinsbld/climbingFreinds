package com.vins.climbingFriends.dto;

import com.vins.climbingFriends.model.Longueur;
import com.vins.climbingFriends.model.SiteEscalade;
import com.vins.climbingFriends.model.Voie;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class SecteurDTO {

    private Long id;

    private String nom;

    private String localisation;

    private String acces;

    private SiteEscalade siteEscalade;

    private List<Voie> voies;

    private List<Longueur> longueurs;


}
