package com.vins.climbingFriends.services.siteescalade;

import com.vins.climbingFriends.dto.SiteEscaladeDTO;
import com.vins.climbingFriends.model.SiteEscalade;

import java.util.List;

public interface ISiteEscaladeService {

    List<SiteEscalade> findAllById(Long id);

    List<SiteEscaladeDTO> getSiteEscaladeWithAllChildren(Long id);
}
