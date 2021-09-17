package com.example.mscandidate.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mscandidate.model.Candidate;
import com.example.mscandidate.repository.CandidateRepository;
import com.example.mscandidate.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService {

	private CandidateRepository candidateRepository;
	
	@Autowired
	public CandidateServiceImpl(
			CandidateRepository candidateRepository) {
		this.candidateRepository = candidateRepository;
	}
	
	@Override
	public void saveCandidates(List<Candidate> candidates) {
		this.candidateRepository.saveCandidates(candidates);
	}

	@Override
	public List<Candidate> findAll(int fromAge, int toAge) {
		return this.candidateRepository.findAll(fromAge, toAge);
	}
}
