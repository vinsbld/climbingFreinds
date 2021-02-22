package com.vins.climbingFriends.services;

import com.vins.climbingFriends.model.Grimpeur;
import com.vins.climbingFriends.repository.IGrimpeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GrimpeurServiceImpl implements IGrimpeurService{

    @Autowired
    IGrimpeurRepository grimpeurRepository;

    @Override
    public Grimpeur save(Grimpeur grimpeur) {
        return grimpeurRepository.save(grimpeur);
    }

    @Override
    public Optional<Grimpeur> findById(Long id) {
        return grimpeurRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        grimpeurRepository.deleteById(id);
    }
}
