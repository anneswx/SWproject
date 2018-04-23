package com.Team12.CS5800.VotingApplication;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.Team12.CS5800.VotingApplication.model.Election;
import com.Team12.CS5800.VotingApplication.model.VotingAndCandidateDAOImpl;
import com.Team12.CS5800.VotingApplication.model.DataConnection.MyConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestVotingAndCandidateDAO {
	
	VotingAndCandidateDAOImpl test = new VotingAndCandidateDAOImpl();
	
	@Test
	public void createElectionTest() {
		String electionName = "ThisIsATest";
		int dateStarted = 111111;
		int dateEnded = 222222;
		int numberOfCandidates = 3;
		int onGoing = 0;
		Election putElection = new Election(electionName, dateStarted, dateEnded, numberOfCandidates);
		Election getElection = new Election("no", 0,0,0);
		
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
	boolean match = putElection.sameCheck(getElection);
	assertEquals(true, putElection.sameCheck(getElection));
	
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
}

		


