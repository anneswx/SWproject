package com.Team12.CS5800.VotingApplication.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.Team12.CS5800.VotingApplication.model.AdminDao;
import com.Team12.CS5800.VotingApplication.model.AdminDaoImpl;
import com.Team12.CS5800.VotingApplication.model.Admin;
import com.Team12.CS5800.VotingApplication.model.CustomerDAOImpl;
import com.Team12.CS5800.VotingApplication.model.CustomerDAO;
import com.Team12.CS5800.VotingApplication.model.Customer;


@Service
public class LoginService {

    public boolean validateUser(String username, String password) {
    		CustomerDAO cd = new CustomerDAOImpl();
    		Customer c = cd.getCustomer(username, password);
    	    if (c != null && c.getUsername() != null) {
    	        return true;
    	    } else {
    	        return false;
    	    }
    	
    }
    
    public boolean validateAdmin(String username, String password) {
    		AdminDao ad = new AdminDaoImpl();
    		Admin a = ad.getAdmin(username, password);
    		if (a != null && a.getAusername() != null){
	        return true;
	    } else {
	        return false;
	    }
    }
    
    public Customer getUser(String username, String password) {
    		CustomerDAO cd = new CustomerDAOImpl();
		Customer c = cd.getCustomer(username, password);
		return c;
    }
    
    public Admin getAdmin(String username, String password) {
    		AdminDao ad = new AdminDaoImpl();
		Admin a = ad.getAdmin(username, password);
		return a;
    }

}
