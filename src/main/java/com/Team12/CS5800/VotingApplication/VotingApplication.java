package com.Team12.CS5800.VotingApplication;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.Team12.CS5800.VotingApplication.model.Candidate;
import com.Team12.CS5800.VotingApplication.model.County;
import com.Team12.CS5800.VotingApplication.model.VotingAndCandidateDAOImpl;

@SpringBootApplication
@ComponentScan("com.Team12.CS5800.VotingApplication")
public class VotingApplication {

	public static void main(String[] args) {
		//SpringApplication.run(VotingApplication.class, args);
		VotingAndCandidateDAOImpl addTest = new VotingAndCandidateDAOImpl();
		try {
			//addTest.createElection("ElectionTestToGet", 777777, 777777, 22, 0);
			
			ArrayList<Candidate> testCandidates = new ArrayList();
			Candidate test = new Candidate("TestCandidate", 13, 2, "TestParty");
			Candidate test2 = new Candidate("TestCandidate2", 13, 2, "TestParty");
			Candidate test3 = new Candidate("TestCandidate3", 13, 2, "TestParty");
			
			testCandidates.add(test);
			testCandidates.add(test2);
			testCandidates.add(test3);

			addTest.addCandidatesToElection(testCandidates, 13);
			
		}catch(Exception e) {
			
		}
		
	}
}