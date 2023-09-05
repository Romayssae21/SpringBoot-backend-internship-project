package com.Romayssae.collaborateur.controller;

import com.Romayssae.collaborateur.dto.TeamDto;
import com.Romayssae.collaborateur.entity.TeamMember;
import com.Romayssae.collaborateur.exceptionHandler.TeamMemberIdNotFoundException;
import com.Romayssae.collaborateur.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TeamController {

    @Autowired
    private TeamService service;
    @PostMapping("/save")
    public ResponseEntity<TeamMember> saveTeamMember(@RequestBody @Valid TeamDto teamDto){
        return new ResponseEntity<>(service.saveTeamMember(teamDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamMember> getTeamMember(@PathVariable int id) throws TeamMemberIdNotFoundException{
        return ResponseEntity.ok(service.getTeamMember(id));
    }

    @GetMapping("fetchAllTeamMembers")
    public ResponseEntity<List<TeamMember>> gztAllTeamMembers(){
        return ResponseEntity.ok(service.getAllTeamMembers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String > deleteTeamMember(@PathVariable int id) throws TeamMemberIdNotFoundException {
        service.deleteTeamMember(id);
        return new ResponseEntity<>("TeamMember with ID " + id + " has been deleted", HttpStatus.OK);

    }

}
