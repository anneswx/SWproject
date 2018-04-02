package com.Team12.CS5800.VotingApplication.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.Team12.CS5800.VotingApplication.model.AdminDao;
import com.Team12.CS5800.VotingApplication.model.AdminDaoImpl;
import com.Team12.CS5800.VotingApplication.model.Admin;
import com.Team12.CS5800.VotingApplication.model.CustomerDAOImpl;
import com.Team12.CS5800.VotingApplication.model.User;
import com.Team12.CS5800.VotingApplication.model.UserDAOImpl;
import com.Team12.CS5800.VotingApplication.model.CustomerDAO;
import com.Team12.CS5800.VotingApplication.model.Customer;


@Service
public class LoginService {
	
	private UserDAOImpl UDAO = new UserDAOImpl();
	
	public boolean validateUser(String username, String password) {
		return UDAO.validateUser(username, password);
	}
	
	public User getUser(String username) {
		return UDAO.getUserWithUsername(username);
	}


}
