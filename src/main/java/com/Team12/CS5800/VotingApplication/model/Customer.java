package com.Team12.CS5800.VotingApplication.model;

public class Customer {

    private int userid;
    private String username;
    private String password;
    private String email;
    private int voterstatus;
    private String realname;
    private int ssn;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    
    //username, password, ssn, address, name, city, state, zipcode, email
    
    public Customer() {
    	
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public int getVoterstatus() {
        return voterstatus;
    }

    public void setVoterstatus(int voterstatus) {
        this.voterstatus = voterstatus;
    }

    public String getRealname() { return realname; }

    public void setRealname(String realname) { this.realname = realname; }

    public int getSsn() { return ssn; }

    public void setSsn(int ssn) { this.ssn = ssn; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }
    
    public String getCity() {return city;}
    
    public void setCity(String city) { this.city = city;}
    
    public String getState() {return state;}
    
    public void setState(String state) { this.state = state; }
    
    public String getZipcode() {return zipcode;}
    
    public void setZipcode(String zipcode) {this.zipcode = zipcode;}

     

}

