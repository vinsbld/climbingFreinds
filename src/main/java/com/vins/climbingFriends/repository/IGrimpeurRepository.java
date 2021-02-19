package com.vins.climbingFriends.repository;

import com.vins.climbingFriends.model.Grimpeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGrimpeurRepository extends JpaRepository<Grimpeur, Long> {

}
