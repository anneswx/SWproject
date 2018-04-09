package com.Team12.CS5800.VotingApplication.model;

import java.util.ArrayList;

public interface VotingAndCandidateDAO {
	//use to create a new election
	public int createElection(String electionName, int dateStarted, int dateEnded, int candidateCount, int onGoing);
	
	//retrieves election from database given the parameter
	public Election getElection(int electionID);
	public Election getElectionWithName(String electionName);
	
	//retrieves candidates who ran in a specified election
	public ArrayList<Candidate> getElectionCandidates(int electionID);
	
	public boolean castVote(int userID, int candidateID);
	
}
