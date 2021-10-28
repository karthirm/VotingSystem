package com.learning.votingsystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.votingsystem.entity.Candidate;
import com.learning.votingsystem.entity.Citizen;
import com.learning.votingsystem.repositories.CandidateRepository;
import com.learning.votingsystem.repositories.CitizenRepository;

@Controller
public class VotingController {
	
	
	public final Logger logger = Logger.getLogger(VotingController.class);

	@Autowired
	CitizenRepository citizenRepository;
	
	@Autowired
	CandidateRepository candidateRepository;
	
	
	@RequestMapping("/")
	public String goToVote() {
		logger.info("Returning vote html file");
		return "vote";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(@RequestParam String name, Model model, HttpSession session) {
		
		logger.info("getting citizen details from database");
		Citizen citizen = citizenRepository.findByName(name);
		
		logger.info("putting citizen into session");
		session.setAttribute("citizen",citizen);
		
		
		if(citizen.getHasVoted()) {
			return "/alreadyVoted";
		} else {
			logger.info("putting candidates into model");
			List<Candidate> candidates = candidateRepository.findAll();
			model.addAttribute("candidates", candidates);
			return "/castVote";
		}
		
	
	}
	
	
	@RequestMapping("voteFor")
		public String voteFor(@RequestParam Long id, HttpSession session) {
			Citizen citizen = (Citizen) session.getAttribute("citizen");
			
			if(!citizen.getHasVoted()) {
				
				citizen.setHasVoted(true);
				
				Candidate candidate = candidateRepository.findById((long)id);
				logger.info("voting for candidate "+candidate.getName());
				candidate.setNumberOfVotes(candidate.getNumberOfVotes()+1);
				
				candidateRepository.save(candidate);
				citizenRepository.save(citizen);
				
				return "voted";
		}
			
		return "alreadyVoted";	
	
	}
}