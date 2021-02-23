package com.vins.climbingFriends.services;

import com.vins.climbingFriends.model.Grimpeur;
import org.springframework.data.repository.query.Param;


public interface IGrimpeurService {

    Grimpeur findByPseudo(@Param("x")String pseudo);

}
