package com.Team12.CS5800.VotingApplication.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.Team12.CS5800.VotingApplication.model.*;


@Controller
@SessionAttributes("name")
public class VoteController {
	
	
	@RequestMapping(value="/vote", method = RequestMethod.GET)
	public String showVotePage(ModelAndView model){
        return "vote";
    }
	@RequestMapping(value="/vote", method = RequestMethod.POST)
	public String showVoteDetails(ModelAndView model){
        return "vote";
    }

}