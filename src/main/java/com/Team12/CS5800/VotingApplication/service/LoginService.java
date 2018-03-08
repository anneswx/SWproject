package com.Team12.CS5800.VotingApplication.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validateUser(String userid, String password) {
        // username, password
        return userid.equalsIgnoreCase("username")
                && password.equalsIgnoreCase("password");
    }

}