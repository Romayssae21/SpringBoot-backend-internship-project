package com.Romayssae.collaborateur.repository;

import com.Romayssae.collaborateur.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<TeamMember,Integer> {
        TeamMember findByTeamMemberFirstName();
        List<TeamMember> findByTeamMemberId();

}
