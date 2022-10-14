package com.java.ipldashboard.repository;

import org.springframework.data.repository.CrudRepository;

import com.java.ipldashboard.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

	Team findByTeamName(String teamName);
}
