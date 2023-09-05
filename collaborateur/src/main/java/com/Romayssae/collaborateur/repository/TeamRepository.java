package com.Romayssae.collaborateur.repository;

import com.Romayssae.collaborateur.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<TeamMember,Integer> {
        TeamMember findById(int id);

}
