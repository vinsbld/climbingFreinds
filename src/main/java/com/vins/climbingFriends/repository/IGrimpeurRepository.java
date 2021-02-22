package com.vins.climbingFriends.repository;

import com.vins.climbingFriends.model.Grimpeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IGrimpeurRepository extends JpaRepository<Grimpeur, Long> {

 Grimpeur save(Grimpeur grimpeur);

 Optional<Grimpeur> findById(Long id);

 void deleteById(Long id);

}
