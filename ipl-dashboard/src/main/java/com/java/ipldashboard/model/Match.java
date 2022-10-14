package com.java.ipldashboard.model;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Match {

	@Id
	private Long id;
	private String city;
	private LocalDate date;
	private String team1;
	private String team2;
	private String venue;
	private String tossWinner;
	private String tossDecision;
	private String winningTeam;
	private String wonBy;// result
	private String margin;// resultMargin
	private String playerOfMatch;
	private String umpire1;
	private String umpire2;

	
	public Match() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getTossWinner() {
		return tossWinner;
	}
	public void setTossWinner(String tossWinner) {
		this.tossWinner = tossWinner;
	}
	public String getTossDecision() {
		return tossDecision;
	}
	public void setTossDecision(String tossDecision) {
		this.tossDecision = tossDecision;
	}
	public String getWinningTeam() {
		return winningTeam;
	}
	public void setWinningTeam(String winningTeam) {
		this.winningTeam = winningTeam;
	}
	public String getWonBy() {
		return wonBy;
	}
	public void setWonBy(String wonBy) {
		this.wonBy = wonBy;
	}
	public String getMargin() {
		return margin;
	}
	public void setMargin(String margin) {
		this.margin = margin;
	}
	public String getPlayerOfMatch() {
		return playerOfMatch;
	}
	public void setPlayerOfMatch(String playerOfMatch) {
		this.playerOfMatch = playerOfMatch;
	}
	public String getUmpire1() {
		return umpire1;
	}
	public void setUmpire1(String umpire1) {
		this.umpire1 = umpire1;
	}
	public String getUmpire2() {
		return umpire2;
	}
	public void setUmpire2(String umpire2) {
		this.umpire2 = umpire2;
	}

	
/*
	public Match() {

	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

//Parsing purpose i have changed local date to date.
	 
	  public LocalDate getDate() 
	  { 
		  return Date; 
	  }
	  
	  
	  public void setDate(LocalDate date) 
	  { 
		  Date = date; 
	  }
	  
	 
	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public String getVenue() {
		return Venue;
	}

	public void setVenue(String venue) {
		Venue = venue;
	}

	public String getTossWinner() {
		return TossWinner;
	}

	public void setTossWinner(String tossWinner) {
		TossWinner = tossWinner;
	}

	public String getTossDecision() {
		return TossDecision;
	}

	public void setTossDecision(String tossDecision) {
		TossDecision = tossDecision;
	}

	public String getWinningTeam() {
		return WinningTeam;
	}

	public void setWinningTeam(String winningTeam) {
		WinningTeam = winningTeam;
	}

	public String getWonBy() {
		return WonBy;
	}

	public void setWonBy(String wonBy) {
		WonBy = wonBy;
	}

	public String getMargin() {
		return Margin;
	}

	public void setMargin(String margin) {
		Margin = margin;
	}

	public String getPlayerOfMatch() {
		return PlayerOfMatch;
	}

	public void setPlayerOfMatch(String playerOfMatch) {
		PlayerOfMatch = playerOfMatch;
	}

	public String getUmpire1() {
		return Umpire1;
	}

	public void setUmpire1(String umpire1) {
		Umpire1 = umpire1;
	}

	public String getUmpire2() {
		return Umpire2;
	}

	public void setUmpire2(String umpire2) {
		Umpire2 = umpire2;
	}


*/
}