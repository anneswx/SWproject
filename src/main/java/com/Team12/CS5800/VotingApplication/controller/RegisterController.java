package com.Team12.CS5800.VotingApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Team12.CS5800.VotingApplication.service.LoginService;
import com.Team12.CS5800.VotingApplication.service.RegisterService;

@Controller
@SessionAttributes("name")
public class RegisterController {
	
	@Autowired
    RegisterService service;

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "register";
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){

       /* boolean isValidUser = service.registerUser(name, password);

        if (!isValidUser) {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }

        model.put("name", name);
        model.put("password", password);
        */

        return "welcome";
    }

}
