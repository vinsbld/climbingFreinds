package com.vins.climbingFriends.services.secteur;

import com.vins.climbingFriends.dto.SecteurDTO;
import com.vins.climbingFriends.dto.VoieDTO;
import com.vins.climbingFriends.model.Longueur;
import com.vins.climbingFriends.model.Secteur;
import com.vins.climbingFriends.model.Voie;
import com.vins.climbingFriends.repository.ISecteurRepository;
import com.vins.climbingFriends.services.longueur.LongueurServiceImpl;
import com.vins.climbingFriends.services.voie.VoieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecteurServiceImpl implements ISecteurService {

    @Autowired
    private ISecteurRepository secteurRepository;

    @Autowired
    private VoieServiceImpl voieService;

    @Autowired
    private LongueurServiceImpl longueurService;


    /**
     * permet de trouver les secteurs associsés à un site d'escalade
     * @param id identifiant du site d'escalade
     * @return la liste des secteurs
     */
    @Override
    public List<Secteur> getSectorsBySiteEscaladeId(Long id) {
        return secteurRepository.getSectorsBySiteEscaladeId(id);
    }

    /**
     * permet de trouver tous les attributs d'un secteur,
     * ceux de ses enfants et ceux son parent
     * @param id indentifiant du secteur
     * @return la liste des attributs secteur, enfants et parent
     */
    @Override
    public List<SecteurDTO> getSectorWithAllChildrenAndParent(Long id){
        List<Secteur> secteurList = secteurRepository.getSectorsBySiteEscaladeId(id);
        List<SecteurDTO> secteurDTOList = new ArrayList<>();
        for (Secteur s : secteurList) {
            SecteurDTO stdo = new SecteurDTO();
            stdo.setSiteEscalade(s.getSiteEscalade());
            List<Voie> voieList = voieService.getVoieBySecteurId(s.getId());
            stdo.setVoies(voieList);
            for (Voie v : voieList) {
                VoieDTO vtdo = new VoieDTO();
                List<Longueur> longueurList = longueurService.getLongueurByVoieId(v.getId());
                vtdo.setLongueurs(longueurList);
                stdo.setLongueurs(vtdo.getLongueurs());
            }secteurDTOList.add(stdo);

        }
        return secteurDTOList;
    }
}
