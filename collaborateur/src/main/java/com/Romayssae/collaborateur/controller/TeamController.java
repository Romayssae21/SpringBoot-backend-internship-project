package com.Romayssae.collaborateur.controller;

import com.Romayssae.collaborateur.dto.TeamDto;
import com.Romayssae.collaborateur.dao.TeamMember;
import com.Romayssae.collaborateur.exceptionHandler.TeamMemberIdNotFoundException;
import com.Romayssae.collaborateur.service.TeamServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TeamController {

    @Autowired
    private TeamServiceInterface service;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome everyone on the non secure endpoint !";
    }
    @PostMapping("/save")
    public ResponseEntity<TeamMember> saveTeamMember(@RequestBody @Valid TeamDto teamDto){
        return new ResponseEntity<>(service.saveTeamMember(teamDto), HttpStatus.CREATED);
    }

    @GetMapping("/save")
    public String getSave(){
        return "Get save method to set token";
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamMember> getTeamMember(@PathVariable Long id) throws TeamMemberIdNotFoundException{
        return ResponseEntity.ok(service.getTeamMember(id));
    }

    @GetMapping("/fetchAllTeamMembers")
    public ResponseEntity<List<TeamMember>> getAllTeamMembers(){
        return ResponseEntity.ok(service.getAllTeamMembers());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String > deleteTeamMember(@PathVariable Long id) throws TeamMemberIdNotFoundException {
        service.deleteTeamMember(id);
        return new ResponseEntity<>("TeamMember with ID " + id + " has been deleted", HttpStatus.OK);

    }

}
