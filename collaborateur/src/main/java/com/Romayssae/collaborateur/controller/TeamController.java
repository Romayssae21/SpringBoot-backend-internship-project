package com.Romayssae.collaborateur.controller;

import com.Romayssae.collaborateur.dto.TeamDto;
import com.Romayssae.collaborateur.entity.TeamMember;
import com.Romayssae.collaborateur.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
@RequestMapping("api/v1")
public class TeamController {

    @Autowired
    private TeamService service;
    @PostMapping("/save")
    public ResponseEntity<TeamMember> saveTeamMember(@RequestBody @Valid TeamDto teamDto){
        return new ResponseEntity<>(service.saveTeamMember(teamDto), HttpStatus.CREATED);
    }
}
