package com.Team12.CS5800.VotingApplication.model;

import java.security.SecureRandom;

public class SessionGrabber {
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();
	
	public String generateSessionID() {
		return randomString(25);
	}

	public String randomString( int len ){
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}

	public String checkAdminStatus(String sessionID) {
		return "";
	}
	
	public int getVoterStatus(String sessionID) {
		return 0;
	}

	public String getRealName(String sessionID) {
		return "";
	}
	
	public String getAddress(String sessionID) {
		return "";
	}
	
	public int getSSN(String sessionID) {
		return 0;
	}
	
	public String getCity(String sessionID) {
		return "";
	}
	
	public String getState(String sessionID) {
		return "";
	}

	public String getZip(String sessionID) {
		return "";
	}


	
}
