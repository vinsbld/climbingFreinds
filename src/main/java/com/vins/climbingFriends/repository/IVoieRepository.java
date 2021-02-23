package com.vins.climbingFriends.repository;

import com.vins.climbingFriends.model.Voie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVoieRepository extends JpaRepository<Voie, Long> {

    @Query("SELECT v FROM Voie v WHERE v.secteur.id= :x")
    List<Voie> getVoieBySecteurId(@Param("x")Long id);

    List<Voie> findAllById(Long id);

}
