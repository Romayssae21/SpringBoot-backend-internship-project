package com.Romayssae.collaborateur.service;

import com.Romayssae.collaborateur.dao.TeamMember;
import com.Romayssae.collaborateur.dto.TeamDto;
import com.Romayssae.collaborateur.exceptionHandler.TeamMemberIdNotFoundException;

import java.util.List;

public interface TeamServiceInterface {
        TeamMember saveTeamMember(TeamDto dto);

        TeamMember getTeamMember(Long id) throws TeamMemberIdNotFoundException;

        List<TeamMember> getAllTeamMembers();

        void deleteTeamMember(Long id) throws TeamMemberIdNotFoundException;
    }

