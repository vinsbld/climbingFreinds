package com.vins.climbingFriends.repository;

import com.vins.climbingFriends.model.SiteEscalade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISiteEscaladeRepository extends JpaRepository<SiteEscalade, Long> {
}
