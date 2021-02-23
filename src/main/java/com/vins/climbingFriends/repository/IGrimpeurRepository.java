package com.vins.climbingFriends.repository;

import com.vins.climbingFriends.model.Grimpeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IGrimpeurRepository extends JpaRepository<Grimpeur, Long> {

    @Query("SELECT g FROM Grimpeur g WHERE g.pseudo= :x")
    Grimpeur findByPseudo(@Param("x")String pseudo);

}
