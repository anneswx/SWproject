package com.Team12.CS5800.VotingApplication.model;

public interface AdminDao {
    int insertAdmin(Admin a);

    Admin getAdmin(String ausername, String apassword);

    boolean isManager(String username) ;

}
