package com.vins.climbingFriends.services.siteescalade;

import com.vins.climbingFriends.dto.SecteurDTO;
import com.vins.climbingFriends.dto.SiteEscaladeDTO;
import com.vins.climbingFriends.dto.VoieDTO;
import com.vins.climbingFriends.model.Longueur;
import com.vins.climbingFriends.model.Secteur;
import com.vins.climbingFriends.model.SiteEscalade;
import com.vins.climbingFriends.model.Voie;
import com.vins.climbingFriends.repository.ISiteEscaladeRepository;
import com.vins.climbingFriends.services.longueur.LongueurServiceImpl;
import com.vins.climbingFriends.services.secteur.SecteurServiceImpl;
import com.vins.climbingFriends.services.voie.VoieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SiteEscaladeServiceImpl implements ISiteEscaladeService {

    @Autowired
    private ISiteEscaladeRepository siteEscaladeRepository;

    @Autowired
    private SecteurServiceImpl secteurService;

    @Autowired
    private VoieServiceImpl voieService;

    @Autowired
    private LongueurServiceImpl longueurService;


    @Override
    public List<SiteEscalade> findAllById(Long id) {
        return siteEscaladeRepository.findAllById(id);
    }

    /**
     * permet de trouver tous les attributs d'un site d'escalade
     * et ceux de ses enfants
     * @return la liste des attributs d'un site d'escalade et de ses enfants
     */
    @Override
    public List<SiteEscaladeDTO> getSiteEscaladeWithAllChildren(Long id) {
        List<SiteEscalade> siteEscaladeList = siteEscaladeRepository.findAllById(id);
        List<SiteEscaladeDTO> siteEscaladeDTOList = new ArrayList<>();
        for (SiteEscalade s : siteEscaladeList) {
            SiteEscaladeDTO stdo = new SiteEscaladeDTO();
            List<Secteur> secteurList = secteurService.getSectorsBySiteEscaladeId(s.getId());
            stdo.setSecteurs(secteurList);
            for (Secteur sector : secteurList) {
                SecteurDTO sectDTO = new SecteurDTO();
                List<Voie> voieList = voieService.getVoieBySecteurId(sector.getId());
                sectDTO.setVoies(voieList);
                stdo.setVoies(sectDTO.getVoies());
                for (Voie v : voieList) {
                    VoieDTO vDTO = new VoieDTO();
                    List<Longueur> longueurList = longueurService.getLongueurByVoieId(v.getId());
                    vDTO.setLongueurs(longueurList);
                    stdo.setLongueurs(vDTO.getLongueurs());
                }siteEscaladeDTOList.add(stdo);
            }
        }
        return siteEscaladeDTOList;
    }
}
