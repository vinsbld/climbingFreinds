package com.vins.climbingFriends.services.secteur;

import com.vins.climbingFriends.dto.SecteurDTO;
import com.vins.climbingFriends.model.Secteur;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISecteurService {

    List<SecteurDTO> getSectorWithAllChildrenAndParent(@Param("x")Long id);

    List<Secteur> getSectorsBySiteEscaladeId(@Param("x")Long id);
}
