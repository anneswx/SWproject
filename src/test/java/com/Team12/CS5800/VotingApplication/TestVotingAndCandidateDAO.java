package com.Team12.CS5800.VotingApplication;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.Team12.CS5800.VotingApplication.model.Candidate;
import com.Team12.CS5800.VotingApplication.model.Election;
import com.Team12.CS5800.VotingApplication.model.GetPrecinct;
import com.Team12.CS5800.VotingApplication.model.VotingAndCandidateDAOImpl;
import com.Team12.CS5800.VotingApplication.model.DataConnection.MyConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TestVotingAndCandidateDAO {
	/***
	 * Tests the precinct lookup is working properly. Checks with the address of Burge residence hall
	 */
	@Test
	public void testPrecinctAPI() {
		GetPrecinct testGetPrecinct = new GetPrecinct();
		
		String correctPrecinct = "IOWA CITY PCT 5";
		String burge = "301 North Clinton Street";
		String burgeCity = "Iowa City";
		String burgeState = "IA";
		
		try {
			String precinctToCheck = testGetPrecinct.precinctLookup(burge, burgeCity, burgeState);
			assertEquals(true, correctPrecinct.equals(precinctToCheck));
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	/***
	 * Checks the creating an election works properly
	 */
	@Test
	public void createElectionTest() {
		VotingAndCandidateDAOImpl test = new VotingAndCandidateDAOImpl();

		String electionName = "ThisIsATest";
		int dateStarted = 111111;
		int dateEnded = 222222;
		int numberOfCandidates = 3;
		int onGoing = 0;
		Election putElection = new Election(electionName, dateStarted, dateEnded, numberOfCandidates);
		Election getElection = new Election("no", 0,0,0);
		
		//tests writing to the database
		try {
			Connection con;
			PreparedStatement ps;
			
			
			
			con = MyConnectionProvider.getCon();
			ps = con.prepareStatement("insert into elections (electionName, electionStartDate, electionEndDate, numberOfCandidates, onGoing)values(?,?,?,?,?)");
			ps.setString(1, electionName);
			ps.setInt(2, dateStarted);
			ps.setInt(3, dateEnded);
			ps.setInt(4, numberOfCandidates);
			ps.setInt(5, onGoing);
			ps.executeUpdate();
			ps.close();
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		//checks if entry previously written to the database is still there
		try {
			Connection con;
			PreparedStatement ps;
		
			int electionID;
			int startDate;
			int endDate;
			int numberOfCandidatez;
			con = MyConnectionProvider.getCon();
			ps = con.prepareStatement("select * from elections where electionName = ?");
			ps.setString(1, electionName);
			
			ResultSet rs = ps.executeQuery();
			rs.first();
			electionID = rs.getInt(1);
			startDate = rs.getInt(3);
			endDate = rs.getInt(4);
			numberOfCandidates = rs.getInt(5);
			
			rs.close();
			ps.close();
			con.close();
			
			
		    getElection = new Election(electionName, startDate, endDate, numberOfCandidates);
		

		
		}catch(Exception e) {
			System.out.println(e);
		}
		
		//checks if test passes
		assertEquals(true, putElection.sameCheck(getElection));
	
		//deletes test entry from elections table
		try{
			Connection con;
			PreparedStatement ps;
		
		
		
			con = MyConnectionProvider.getCon();
			ps = con.prepareStatement("DELETE FROM elections WHERE electionName = ?");
			ps.setString(1, electionName);
			ps.executeUpdate();

			ps.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	/***
	 * Tests ability to get elections from the elections table
	 */
	@Test
	public void testGetElection() {
		Election results;
		Election correctResults = new Election(13, "ElectionTestToGet", 777777, 777777, 22);
		try {
			Connection con;
			PreparedStatement ps;
			int electionID;
			int startDate;
			int endDate;
			int numberOfCandidates;
			String electionName ="ElectionTestToGet";
			con = MyConnectionProvider.getCon();
			ps = con.prepareStatement("select * from elections where electionName = ?");
			ps.setString(1, electionName);
			
			ResultSet rs = ps.executeQuery();
			rs.first();
			electionID = rs.getInt(1);
			startDate = rs.getInt(3);
			endDate = rs.getInt(4);
			numberOfCandidates = rs.getInt(5);
			
			rs.close();
			ps.close();
			con.close();
			
			
			results = new Election(electionID, electionName, startDate, endDate, numberOfCandidates);
			
		} catch(Exception e) {
			System.out.println(e);
			results = new Election(1, "Test", 1,2,3);
		}
		
		assertEquals(true, correctResults.sameCheck(results));
	}
	
	@Test
	public void testGetElectionCandidates() {
		ArrayList<Candidate> correctCandidateList = new ArrayList();
		Candidate candidate1 = new Candidate("TestCandidate", 13, 2, "TestParty");
		Candidate candidate2 = new Candidate("TestCandidate2", 13, 2, "TestParty");
		Candidate candidate3 = new Candidate("TestCandidate3", 13, 2, "TestParty");
		correctCandidateList.add(candidate1);
		correctCandidateList.add(candidate2);
		correctCandidateList.add(candidate3);
		
		ArrayList<Candidate> candidatesToCheck = new ArrayList<Candidate>();
		
		try {
			Connection con;
			PreparedStatement ps;
			
			int electionID = 13;
			int candidateID;
			String candidateName = new String();
			int winnerStatusInt;
			boolean winnerStatus;
			int votesRecieved;
			String party;
			
			con = MyConnectionProvider.getCon();
			ps = con.prepareStatement("select * from candidate_info where electionID = ?");
			ps.setInt(1, electionID);
			
			ResultSet rs = ps.executeQuery();
			rs.first();
			
			boolean lastRowCheck = rs.isLast();
			boolean atLastRowFlag = lastRowCheck;
			while(!lastRowCheck){
				
				candidateID = rs.getInt(1);
				candidateName = rs.getString(2);
				party = rs.getString(4);
				winnerStatusInt = rs.getInt(5);
				votesRecieved = rs.getInt(6);
				
				
				if(winnerStatusInt ==1) {
					winnerStatus = true;
				}
				else {
					winnerStatus = false;
				}
				
				candidatesToCheck.add(new Candidate(candidateID,candidateName, electionID, winnerStatus, votesRecieved, party)); //name, electionID, winnerStatus, votesRecieved, party
				rs.next();
				
				if(atLastRowFlag == true) {
					lastRowCheck = true;
				}
				
				if(rs.isLast() ==true) {
					atLastRowFlag = true;
				}
				
			}
			
			
			rs.close();
			ps.close();
			con.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		for(int i=0; i<correctCandidateList.size(); i++) {
			Candidate a = correctCandidateList.get(i);
			Candidate b = candidatesToCheck.get(i);
			
			a.equals(b);
		}
		
		
		assertEquals(true, correctCandidateList.equals(candidatesToCheck) );

		
	}
	
	
	
}

		


