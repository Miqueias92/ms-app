package com.example.mscandidate.service;

import java.util.List;

import com.example.mscandidate.model.Candidate;

public interface CandidateService {
	
	void saveCandidates(List<Candidate> candidates);
	List<Candidate> findAll(int fromAge, int toAge);
}
