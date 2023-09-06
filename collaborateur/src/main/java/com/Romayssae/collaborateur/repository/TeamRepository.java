package com.Romayssae.collaborateur.repository;

import com.Romayssae.collaborateur.dao.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<TeamMember,Integer> {
        TeamMember findById(Long id);

}
