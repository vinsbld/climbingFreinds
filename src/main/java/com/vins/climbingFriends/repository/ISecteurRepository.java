package com.vins.climbingFriends.repository;

import com.vins.climbingFriends.model.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISecteurRepository extends JpaRepository<Secteur, Long> {

    @Query("SELECT s FROM Secteur s WHERE s.siteEscalade.id = :x")
    List<Secteur> getSectorsBySiteEscaladeId(@Param("x")Long id);
}
