package com.Team12.CS5800.VotingApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.Team12.CS5800.VotingApplication.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelAndView model){
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView showHomePage(ModelAndView model, @RequestParam String username, @RequestParam String password){

        boolean isValidUser = service.validateUser(username, password);

        if (!isValidUser) {
            model.addObject("errorMessage", "Invalid Credentials");
            return model;
        }

        model.addObject("username", username);
        
        model.addObject("successMessage", "You've been logged in!");

        
        return model;
    }

}