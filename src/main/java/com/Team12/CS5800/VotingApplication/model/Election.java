package com.Team12.CS5800.VotingApplication.model;

import java.util.ArrayList;

public class Election {
	private int electionID;
	private String electionName;
	private int dateStarted;
	private int dateEnded;
	private Candidate winner;
	private ArrayList<Candidate> candidateList;
	private int numberOfCandidates;
	
	public Election(int electionID, String electionName, int dateStarted, int dateEnded, int numberOfCandidates) {
		this.electionID = electionID;
		this.electionName = electionName;
		this.dateStarted = dateStarted;
		this.dateEnded = dateEnded;
		this.numberOfCandidates = numberOfCandidates;
		this.candidateList = fillCandidateList(electionID);
	}
	
	private static ArrayList<Candidate> fillCandidateList(int electionID) {
		ArrayList<Candidate> candidateList = new ArrayList<>();
		
		return candidateList;
	}
	
	public int getElectionID() {
		return electionID;
	}
	
	public String getElectionName() {
		return electionName;
	}
	
	

}
