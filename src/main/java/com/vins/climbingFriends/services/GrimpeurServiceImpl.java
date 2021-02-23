package com.vins.climbingFriends.services;

import com.vins.climbingFriends.model.Grimpeur;
import com.vins.climbingFriends.repository.IGrimpeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class GrimpeurServiceImpl implements IGrimpeurService{

    @Autowired
    IGrimpeurRepository grimpeurRepository;


    /**
     * permet de trouver un utilisateur par son pseudo
     * @param pseudo pseudo de l'utilisateur
     * @return l'utilisateur
     */
    @Override
    public Grimpeur findByPseudo(String pseudo) {
        return grimpeurRepository.findByPseudo(pseudo);
    }
}
