package com.vins.climbingFriends.services.longueur;

import com.vins.climbingFriends.model.Longueur;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ILongueurService {

    List<Longueur> getLongueurByVoieId(@Param("x")Long id);
}
