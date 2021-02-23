package com.vins.climbingFriends.dto;

import com.vins.climbingFriends.model.Longueur;
import com.vins.climbingFriends.model.Secteur;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class VoieDTO {

    private Long id;

    private String cotation;

    private Secteur secteur;

    private List<Longueur> longueurs;
}
