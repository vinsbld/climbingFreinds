package com.vins.climbingFriends.services.voie;

import com.vins.climbingFriends.dto.VoieDTO;
import com.vins.climbingFriends.model.Longueur;
import com.vins.climbingFriends.model.Voie;
import com.vins.climbingFriends.repository.IVoieRepository;
import com.vins.climbingFriends.services.longueur.ILongueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoieServiceImpl implements IVoieService{

    @Autowired
    private IVoieRepository voieRepository;

    @Autowired
    private ILongueurService longueurService;

    /**
     * permet de trouver les voies assiciées à un secteur
     * @param id identifiant du secteur
     * @return la liste des voies
     */
    @Override
    public List<Voie> getVoieBySecteurId(Long id) {
        return voieRepository.getVoieBySecteurId(id);
    }

    /**
     * permet de trouver tous les attributs d'une voie,
     * ceux de ses enfants et ceux de ses parents
     * @param id indentifiant de la voie
     * @return la liste des attributs voie, enfants et parents
     */
    @Override
    public List<VoieDTO> getVoieWithAllChildrenandParents(Long id) {
        List<Voie> voieList = voieRepository.findAllById(id);
        List<VoieDTO> voieDTOList = new ArrayList<>();
        for (Voie v : voieList) {
            VoieDTO vtdo = new VoieDTO();
            List<Longueur> longueurList = longueurService.getLongueurByVoieId(v.getId());
            vtdo.setLongueurs(longueurList);
            voieDTOList.add(vtdo);
        }
        return voieDTOList;
    }

    @Override
    public List<Voie> findAllById(Long id) {
        return voieRepository.findAllById(id);
    }
}
