package com.vins.climbingFriends.repository;

import com.vins.climbingFriends.model.Voie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVoieRepository extends JpaRepository<Voie, Long> {
}
