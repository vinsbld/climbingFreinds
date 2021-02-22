package com.vins.climbingFriends.services;

import com.vins.climbingFriends.model.Grimpeur;

import java.util.Optional;

public interface IGrimpeurService {

    Grimpeur save(Grimpeur grimpeur);

    Optional<Grimpeur> findById(Long id);

    void deleteById(Long id);
}
