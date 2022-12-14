package com.java.ipldashboard.data;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.java.ipldashboard.model.Match;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	private final String[] FIELD_NAMES = new String[]{
			"ID","City","Date","Season","MatchNumber","Team1","Team2","Venue","TossWinner","TossDecision","SuperOver","WinningTeam","WonBy","Margin","method","Player_of_Match","Team1Players","Team2Players","Umpire1","Umpire2"
	};
	
	@Autowired
	  public JobBuilderFactory jobBuilderFactory;

	  @Autowired
	  public StepBuilderFactory stepBuilderFactory;

	  @Bean
	  public FlatFileItemReader<MatchData> reader() {
	    return new FlatFileItemReaderBuilder<MatchData>()
	      .name("MatchItemReader")
	      .resource(new ClassPathResource("match-data.csv"))
	      .delimited()
	      .names(FIELD_NAMES)
	      .fieldSetMapper(new BeanWrapperFieldSetMapper<MatchData>() {{
	        setTargetType(MatchData.class);
	      }})
	      .build();
	  }

	  @Bean
	  public MatchDataProcessor processor() {
	    return new MatchDataProcessor();
	  }

	  @Bean
	  public JdbcBatchItemWriter<Match> writer(DataSource dataSource) {
	    return new JdbcBatchItemWriterBuilder<Match>()
	      .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
	      .sql("INSERT INTO match (id,city,date,team1,team2,venue,toss_winner,toss_decision,winning_team,won_by,margin,player_of_match,umpire1,umpire2)"
	      		+ "VALUES (:id,:city,:date,:team1,:team2,:venue,:tossWinner,:tossDecision,:winningTeam,:wonBy,:margin,:playerOfMatch,:umpire1,:umpire2)")
	      .dataSource(dataSource)
	      .build();
	  }
	  
	  @Bean
	  public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
	    return jobBuilderFactory.get("importUserJob")
	      .incrementer(new RunIdIncrementer())
	      .listener(listener)
	      .flow(step1)
	      .end()
	      .build();
	  }

	  @Bean
	  public Step step1(JdbcBatchItemWriter<Match> writer) {
	    return stepBuilderFactory.get("step1")
	      .<MatchData, Match> chunk(10)
	      .reader(reader())
	      .processor(processor())
	      .writer(writer)
	      .build();
	  }
}
