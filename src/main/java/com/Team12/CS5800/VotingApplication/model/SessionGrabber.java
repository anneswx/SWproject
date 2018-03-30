package com.Team12.CS5800.VotingApplication.model;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.Team12.CS5800.VotingApplication.model.DataConnection.MyConnectionProvider;

public class SessionGrabber {
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();
	
	static Connection con;
    static PreparedStatement ps;
	
	public String generateSessionID() {
		return randomString(25);
	}
	
	public int storeSession(String sessionID, int userID) {
		int status = 0;
		try {
			con = MyConnectionProvider.getCon();
			ps = con.prepareStatement("insert into sessions (sessionid, userid) values (?,?)");
			ps.setString(1, sessionID);
			ps.setInt(2, userID);
			status = ps.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public int removeSession(String sessionID) {
		int status = 0;
		try {
			con = MyConnectionProvider.getCon();
			ps = con.prepareStatement("delete from sessions where sessionid=?");
			ps.setString(1, sessionID);
			status = ps.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	/*
	 * DELETE FROM Customers
WHERE CustomerName='Alfreds Futterkiste';

	 *  public int insertCustomer(Customer c) {
        int status = 0;
        try {
            con = MyConnectionProvider.getCon();
            ps = con.prepareStatement("insert into customer (username, password,email)values(?,?,?)");
            ps.setString(1, c.getUsername());
            ps.setString(2, c.getPassword());
            ps.setString(3, c.getEmail());
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
	 */

	public String randomString( int len ){
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}

	public String checkAdminStatus(String sessionID) {
		return "admin";
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
