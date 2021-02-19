package com.vins.climbingFriends.repository;

import com.vins.climbingFriends.model.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISecteurRepository extends JpaRepository<Secteur, Long> {
}
