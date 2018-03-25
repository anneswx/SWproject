package com.Team12.CS5800.VotingApplication.model;

public interface CustomerDAO {

    int insertCustomer(Customer c);

    boolean isNewUsername(String username);

    Customer getCustomer(String username, String password);

    int updateVoterinfo(Customer c);

}
