package com.vins.climbingFriends.repository;

import com.vins.climbingFriends.model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentaireRepository extends JpaRepository<Commentaire, Long> {
}
