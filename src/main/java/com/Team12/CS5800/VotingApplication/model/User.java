package com.Team12.CS5800.VotingApplication.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Team12.CS5800.VotingApplication.model.DataConnection.MyConnectionProvider;

public class User {
	
	private class UserInfo {
		
		 private String email;
		 private VoterStatus voterstatus;
		 private String firstName;
		 private String lastName;
		 private int ssn;
		 private String address;
		 private String city;
		 private String state;
		 private String zipcode;
		 
		 public UserInfo( String email, int voterstatus, String firstName, String lastName, int ssn, String address, String city, String state, String zipcode) {
			 this.email = email;
			 if(voterstatus == 0) {
				 this.voterstatus = VoterStatus.NOT_APPLIED;
			 }
			 else if (voterstatus == 1) {
				 this.voterstatus = VoterStatus.APPLIED;
			 }
			 else {
				 this.voterstatus = VoterStatus.APPROVED;
			 }
			 this.firstName = firstName;
			 this.lastName = lastName;
			 this.ssn = ssn;
			 this.address = address;
			 this.city = city;
			 this.state = state;
			 this.zipcode = zipcode;
		 }
		 
		 public String getEmail() {
			 return email;
		 }
		 
		 public VoterStatus getVoterStatus() {
			 return voterstatus;
		 }
		 
		 public String getFirstName() {
			 return firstName;
		 }
		 
		 public String getLastName() {
			 return lastName;
		 }
		 
		 public int getSSN() {
			 return ssn;
		 }
		 
		 public String getAddress() {
			 return address;
		 }
		 
		 public String getCity() {
			 return city;
		 }
		 
		 public String getState() {
			 return state;
		 }
		 
		 public String getZipCode() {
			 return zipcode;
		 }
		 
		 public void setEmail(String newEmail) {
			 this.email = newEmail;
		 }
		 
		 public void setVoterStatus(VoterStatus newStatus) {
			 this.voterstatus = newStatus;
		 }
		 
		 public void setFirstName(String newFirstName) {
			 this.firstName = newFirstName;
		 }
		 
		 public void setLastName(String newLastName) {
			 this.lastName = newLastName;
		 }
		 
		 public void setSSN(int newSSN) {
			 this.ssn = newSSN;
		 }
		 
		 public void setAddress(String newAddress) {
			 this.address = newAddress;
		 }
		 
		 public void setCity(String newCity) {
			 this.city = newCity;
		 }
		 
		 public void setState(String newState) {
			 this.state = newState;
		 }
		 
		 public void setZipCode(String newZip) {
			 this.zipcode = newZip;
		 }

	}
	
	
	private int id;
    private String username;
    private String password;
    private AdminStatus adminStatus;
    private UserInfo userInfo;
    
    public User( int id, String username, String password, int adminStatus, String email, int voterstatus, String firstName, String lastName, int ssn, String address, String city, String state, String zipcode) {
    		// manual set all these fields DON'T USE SET
    }
    
    public int getID() {
    		return id;
    }
    
    public String getUsername() {
    		return username;
    }
    
    public void setUsername(String newUsername) {
    		username = newUsername;
    		// update db
    }
    
    public String getPassword() {
    		return password;
    }
    
    public void setPassword(String newPassword) {
    		password = newPassword;
    		// update db
    }
    
    public AdminStatus getAdminStatus() {
    		return adminStatus;
    }
    
    public void setAdminStatus(AdminStatus newStatus) {
    		adminStatus = newStatus;
    		// update db
    }
    
    public String getEmail() {
    		return userInfo.getEmail();
    }
    
    public void setEmail(String newEmail) {
    		userInfo.setEmail(newEmail);
    		// Access DB
    }
    
    public VoterStatus getVoterStatus() {
    		return userInfo.getVoterStatus();
    };
    
    public void setVoterStatus(VoterStatus newStatus) {
    		userInfo.setVoterStatus(newStatus);
    		// access db
    }
    
    public String getFirstName() {
    		return userInfo.getFirstName();
    }
    
    public void setFirstName(String newFirstName) {
    		userInfo.setFirstName(newFirstName);
    		// access db
    }
    
    public String getLastName() {
    		return userInfo.getLastName();
    }
    
    public void setLastName(String newLastName) {
    		userInfo.setLastName(newLastName);
    		// access db
    }
    
    public int getSSN() {
    		return userInfo.getSSN();
    }
    
    public void setSSN(int newSSN) {
    		userInfo.setSSN(newSSN);
    		// access db
    }
    
    public String getAddress() {
    		return userInfo.getAddress();
    }
    
    public void setAddress(String newAddress) {
    		userInfo.setAddress(newAddress);
    		// access db
    }
    
    public String getCity() {
    		return userInfo.getCity();
    }
    
    public void setCity(String newCity) {
    		userInfo.setCity(newCity);
    		// access db
    }
    
    public String getState() {
    		return userInfo.getState();
    }
    
    public void setState(String newState) {
    		userInfo.setState(newState);
    		// access db
    }
    
    public String getZipCode() {
    		return userInfo.getZipCode();
    }
    
    public void setZipCode(String newZipCode) {
    		userInfo.setZipCode(newZipCode);
    		// access db
    }
    
    
   

}