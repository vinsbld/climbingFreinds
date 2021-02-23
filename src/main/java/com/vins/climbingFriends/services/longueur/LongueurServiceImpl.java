package com.vins.climbingFriends.services.longueur;

import com.vins.climbingFriends.model.Longueur;
import com.vins.climbingFriends.repository.ILongueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LongueurServiceImpl implements ILongueurService{

    @Autowired
    private ILongueurRepository longueurRepository;

    /**
     * permet de trouver les longueurs associées à une voie
     * @param id identifiant de la voie
     * @return la liste des longueurs
     */
    @Override
    public List<Longueur> getLongueurByVoieId(Long id) {
        return longueurRepository.getLongueurByVoieId(id);
    }
}
