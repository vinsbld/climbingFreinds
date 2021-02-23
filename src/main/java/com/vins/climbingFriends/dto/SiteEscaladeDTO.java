package com.vins.climbingFriends.dto;

import com.vins.climbingFriends.model.Commentaire;
import com.vins.climbingFriends.model.Longueur;
import com.vins.climbingFriends.model.Secteur;
import com.vins.climbingFriends.model.Voie;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class SiteEscaladeDTO {

    private Long id;

    private String nomDuSite;

    boolean officiel;

    private List<Commentaire> commentaires;

    private List<Secteur> secteurs;

    private List<Voie> voies;

    private List<Longueur> longueurs;


}
