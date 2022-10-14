package com.java.ipldashboard.data;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import com.java.ipldashboard.model.Match;

	
	public class MatchDataProcessor  implements ItemProcessor<MatchData, Match> {

	  private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

	  @Override
	  public Match process(final MatchData matchData) throws Exception {
	    
		  Match match = new Match();
		  match.setId(Long.parseLong(matchData.getID()));
		  match.setCity(matchData.getCity());
		  
//Note:  This code is for converting Date format "DD-MM-YYYY" to "YYYY-MM-DD".  
//		  String startDateString = "08-12-2017";
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		  DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		  System.out.println(LocalDate.parse(matchData.getDate(), formatter).format(formatter2));
		  String finalParseDate = LocalDate.parse(matchData.getDate(), formatter).format(formatter2);
		 
		  match.setDate(LocalDate.parse(finalParseDate));
		  match.setTeam1(matchData.getTeam1());
		  match.setTeam2(matchData.getTeam2());
		  match.setVenue(matchData.getVenue());
		  match.setTossWinner(matchData.getTossWinner());
		  match.setTossDecision(matchData.getTossDecision());
		  match.setWinningTeam(matchData.getWinningTeam());
		  match.setWonBy(matchData.getWonBy());
		  match.setMargin(matchData.getMargin());
		  match.setPlayerOfMatch(matchData.getPlayer_of_Match());
		  match.setUmpire1(matchData.getUmpire1());
		  match.setUmpire2(matchData.getUmpire2());
		  
		  //Set team1 and team2 depending upon toss winner
		  String firstInningTeam,secondInningTeam;
		  if("bat".equals(matchData.getTossDecision())) {
			  firstInningTeam = matchData.getTossWinner();
			  secondInningTeam = matchData.getTossWinner()
					  .equals(matchData.getTeam1()) ? matchData.getTeam2() 
							  : matchData.getTeam1();
		  }else
		  {
			  secondInningTeam = matchData.getTossWinner();
			  firstInningTeam = matchData.getTossWinner()
					  .equals(matchData.getTeam1()) ? matchData.getTeam2() 
							  : matchData.getTeam1();
		  }
		  
		  match.setTeam1(firstInningTeam);
		  match.setTeam2(secondInningTeam);
		  
		  
		  
		  
		  return match;
	  }
}
