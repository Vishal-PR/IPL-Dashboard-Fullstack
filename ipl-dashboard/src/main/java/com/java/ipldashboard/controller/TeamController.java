package com.java.ipldashboard.controller;



import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.java.ipldashboard.model.Team;
import com.java.ipldashboard.repository.MatchRepository;
import com.java.ipldashboard.repository.TeamRepository;

@RestController
@CrossOrigin
public class TeamController {

	private TeamRepository teamRepository;
	private MatchRepository matchRepository;

	
	public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
		this.teamRepository = teamRepository;
		this.matchRepository = matchRepository;
	}


	@GetMapping("/team/{teamName}")
	public Team findByTeamName(@PathVariable String teamName) {
		
		Team team = this.teamRepository.findByTeamName(teamName);
		
		team.setMatches(matchRepository.findLastestMatchesByTeam(teamName,4));
		
		return team;
	}
	
}
