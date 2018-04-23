package com.Team12.CS5800.VotingApplication.service;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Team12.CS5800.VotingApplication.model.VotingAndCandidateDAO;
import com.Team12.CS5800.VotingApplication.model.VotingAndCandidateDAOImpl;

@Service
public class PollService {

	private VotingAndCandidateDAOImpl VDAO = new VotingAndCandidateDAOImpl();

	public boolean registerElection(String electionName, int dateStarted, int dateEnded, int candidateCount, int onGoing) {
			
		int status = VDAO.createElection(electionName, dateStarted, dateEnded, candidateCount, onGoing);

		if (status == 1) {
			return true;
		}
		else {
			return false;
		}

    }
}
