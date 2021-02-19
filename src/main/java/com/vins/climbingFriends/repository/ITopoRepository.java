package com.vins.climbingFriends.repository;

import com.vins.climbingFriends.model.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITopoRepository extends JpaRepository<Topo, Long> {
}
