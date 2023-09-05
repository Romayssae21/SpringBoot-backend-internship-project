package com.Romayssae.collaborateur.service;

import com.Romayssae.collaborateur.dto.TeamDto;
import com.Romayssae.collaborateur.entity.TeamMember;
import com.Romayssae.collaborateur.exceptionHandler.TeamMemberIdNotFoundException;
import com.Romayssae.collaborateur.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository repository ;
    public TeamMember saveTeamMember(TeamDto dto){
        TeamMember teamMember = TeamMember
                .builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .build();
        return repository.save(teamMember);
    }

    public TeamMember getTeamMember(int id) throws TeamMemberIdNotFoundException {
        TeamMember teamMember = repository.findById(id);
        if (teamMember != null){
            return teamMember;
        }
        else {
            throw new TeamMemberIdNotFoundException("The Team member not found for id = "+id);
        }
    }

    public List<TeamMember> getAllTeamMembers(){
        return repository.findAll();
    }
    public  void deleteTeamMember(int id) throws TeamMemberIdNotFoundException{
        Optional<TeamMember> optionalTeamMember = Optional.ofNullable(repository.findById(id));
        optionalTeamMember.ifPresentOrElse(
                teamMember -> {
                    repository.delete(teamMember);
                },
        ()->{
            try {
                throw  new TeamMemberIdNotFoundException
                        ("TeamMember with ID" + id + " cannot be deleted, member not found");
            } catch (TeamMemberIdNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        );
    }


}
