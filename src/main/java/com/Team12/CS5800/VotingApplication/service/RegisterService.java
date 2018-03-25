package com.Team12.CS5800.VotingApplication.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
	
	public boolean registerUser(String userid, String password, String email, String socialSecurity, String address) {
        // username, password
        return userid.equalsIgnoreCase("username")
                && password.equalsIgnoreCase("password");
    }

}
