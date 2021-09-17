package com.example.mscandidate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mscandidate.model.Candidate;
import com.example.mscandidate.service.CandidateService;

@RestController
public class CandidateController {
	
	private CandidateService candidateService;
	
	@Autowired
	public CandidateController(
			CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	
	@RequestMapping(path = "/candidatos", method = RequestMethod.GET)
	public ResponseEntity<List<Candidate>> findAll(
			@RequestParam(defaultValue = "0", required = false) int fromAge,
			@RequestParam(defaultValue = "100", required = false) int toAge) {
		
		if (fromAge > toAge) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(candidateService.findAll(fromAge, toAge));
	}
}
