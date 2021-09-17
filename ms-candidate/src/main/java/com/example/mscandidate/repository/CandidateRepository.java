package com.example.mscandidate.repository;

import java.util.List;

import com.example.mscandidate.model.Candidate;

public interface CandidateRepository {
	void saveCandidates(List<Candidate> candidates);
	List<Candidate> findAll(int fromAge, int toAge);
}
