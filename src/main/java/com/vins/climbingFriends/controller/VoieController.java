package com.vins.climbingFriends.controller;

import com.vins.climbingFriends.dto.VoieDTO;
import com.vins.climbingFriends.services.voie.VoieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VoieController {

    @Autowired
    private VoieServiceImpl voieService;

    @GetMapping("/voie/{id}")
    public List<VoieDTO> findByIdVoie(@PathVariable("id")Long id){
        return voieService.getVoieWithAllChildrenandParents(id);
    }
}
