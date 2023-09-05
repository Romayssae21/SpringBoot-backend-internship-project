package com.Romayssae.collaborateur.controller;

import com.Romayssae.collaborateur.entity.TeamMember;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class TeamController {

    @PostMapping("/save")
    public String addTeamMember(@RequestBody TeamMember teamMember){

    }
}
