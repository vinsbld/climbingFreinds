package com.vins.climbingFriends.repository;

import com.vins.climbingFriends.model.Longueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILongueurRepository extends JpaRepository<Longueur, Long> {

    @Query("SELECT l FROM Longueur l WHERE l.voie.id = :x")
    List<Longueur> getLongueurByVoieId(@Param("x")Long id);

}
