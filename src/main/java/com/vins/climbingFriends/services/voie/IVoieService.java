package com.vins.climbingFriends.services.voie;

import com.vins.climbingFriends.dto.VoieDTO;
import com.vins.climbingFriends.model.Voie;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVoieService {

    List<Voie> getVoieBySecteurId(@Param("x")Long id);

    List<VoieDTO> getVoieWithAllChildrenandParents(Long id);

    List<Voie> findAllById(Long id);
}
