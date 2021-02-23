package com.vins.climbingFriends.controller;

import com.vins.climbingFriends.model.SiteEscalade;
import com.vins.climbingFriends.repository.ISiteEscaladeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SiteEscaladeController {

    @Autowired
    ISiteEscaladeRepository siteEscaladeRepository;

    @GetMapping(value = "/sites-escalades")
    public List<SiteEscalade> listSitesEscalades(){
        return siteEscaladeRepository.findAll();
    }

    @GetMapping("/site-escalade/{id}")
    public SiteEscalade findById(@PathVariable("id")Long id){
        return siteEscaladeRepository.findById(id).get();
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
