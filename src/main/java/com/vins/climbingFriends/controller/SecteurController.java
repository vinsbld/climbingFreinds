package com.vins.climbingFriends.controller;

import com.vins.climbingFriends.dto.SecteurDTO;
import com.vins.climbingFriends.services.secteur.SecteurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SecteurController {

    @Autowired
    SecteurServiceImpl secteurService;

    @GetMapping("/secteur/{id}")
    public List<SecteurDTO> findById(@PathVariable("id")Long id){
        return secteurService.getSectorWithAllChildrenAndParent(id);
    }

}
