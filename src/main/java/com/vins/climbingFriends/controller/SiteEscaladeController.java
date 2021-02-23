package com.vins.climbingFriends.controller;

import com.vins.climbingFriends.dto.SiteEscaladeDTO;
import com.vins.climbingFriends.model.SiteEscalade;
import com.vins.climbingFriends.repository.ISiteEscaladeRepository;
import com.vins.climbingFriends.services.siteescalade.SiteEscaladeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SiteEscaladeController {

    @Autowired
    ISiteEscaladeRepository siteEscaladeRepository;

    @Autowired
    SiteEscaladeServiceImpl siteEscaladeService;

    @GetMapping("/site-escalade/{id}")
    public List<SiteEscaladeDTO> findByIdSite(@PathVariable("id")Long id){
        return siteEscaladeService.getSiteEscaladeWithAllChildren(id);
    }

    @GetMapping(value = "/sites-escalades")
    public List<SiteEscalade> listSitesEscalades(){
        return siteEscaladeRepository.findAll();
    }

    @PostMapping("/save/site-escalade")
    public SiteEscalade save(@RequestBody SiteEscalade siteEscalade){
        return siteEscaladeRepository.save(siteEscalade);
    }

    @PutMapping("/update/site-escalade/{id}")
    public SiteEscalade update(@PathVariable("id")Long id, @RequestBody SiteEscalade siteEscalade){
        siteEscalade.setId(id);
        return siteEscaladeRepository.save(siteEscalade);
    }


    @DeleteMapping("/delete/site-escalade/{id}")
    public void delete(@PathVariable("id")Long id){
        siteEscaladeRepository.deleteById(id);
    }
}
