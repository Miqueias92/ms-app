package com.example.mscandidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.mscandidate.model.Candidate;
import com.example.mscandidate.service.CandidateService;
import com.example.mscandidate.service.JsonReadService;

@Component
public class MsCandidateApplicationStartupRunner implements ApplicationRunner {
	
	private JsonReadService jsonService;
	private CandidateService candidateService;
	
	@Autowired
	public MsCandidateApplicationStartupRunner(
			JsonReadService jsonService,
			CandidateService candidateService) {
		
		this.jsonService = jsonService;
		this.candidateService = candidateService;
	}
	
	@Override
	public void run(ApplicationArguments args) 
			throws Exception {
		
		candidateService.saveCandidates(
				jsonService.readCandidatesFromJson()
		);
	}
}
