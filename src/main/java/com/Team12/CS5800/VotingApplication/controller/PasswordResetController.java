package com.Team12.CS5800.VotingApplication.controller;

import java.time.LocalDateTime;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.Team12.CS5800.VotingApplication.model.SessionGrabber;
import com.Team12.CS5800.VotingApplication.service.RequestPasswordResetService;



@Controller
@SessionAttributes("name")
public class PasswordResetController {

    @Autowired
    RequestPasswordResetService service;

    @RequestMapping(value="/forgotPassword", method = RequestMethod.GET)
    public String showLoginPage(ModelAndView model){
        return "forgotPasswordRequest";
    }

    @RequestMapping(value="/forgotPassword", method = RequestMethod.POST)
    public ModelAndView showHomePage(ModelAndView model, @RequestParam String email, HttpServletResponse response){
    		/*
    		int userID;
    		boolean isValidLogin = service.validateUser(username, password);
    		if (!isValidLogin) {
    			model.addObject("errorMessage", "Invalid Credentials");
	        return model;
    		} else {
    			userID = service.getUser(username).getID();
    		}
        
        model.setViewName("redirect:/");

        SessionGrabber sg = new SessionGrabber();
        
        String cookieToAdd = sg.generateSessionID() + LocalDateTime.now();
        
        sg.storeSession(cookieToAdd, userID);
        
        response.addCookie(new Cookie("sessionID", cookieToAdd));
        */
        
        return model;
    }

}