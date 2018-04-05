package com.Team12.CS5800.VotingApplication.model;

public interface UserDAO {
	
	public int insertUser( String username, String password, int adminStatus, String email, int voterstatus, String firstName, String lastName, int ssn, String address, String city, String state, String zipcode, String precinct );
	
	public User getUser(String sessionID);
	
	public int updateUser(User user);


}
