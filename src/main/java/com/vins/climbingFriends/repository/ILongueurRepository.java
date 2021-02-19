package com.vins.climbingFriends.repository;

import com.vins.climbingFriends.model.Longueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILongueurRepository extends JpaRepository<Longueur, Long> {
}
