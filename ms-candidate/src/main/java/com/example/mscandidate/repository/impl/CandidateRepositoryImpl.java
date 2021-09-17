package com.example.mscandidate.repository.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.mscandidate.database.DatabaseMemory;
import com.example.mscandidate.model.Candidate;
import com.example.mscandidate.repository.CandidateRepository;

@Repository
public class CandidateRepositoryImpl implements CandidateRepository {

	@Override
	public void saveCandidates(List<Candidate> candidates) {
		DatabaseMemory.CandadatesList.addAll(candidates);
	}

	@Override
	public List<Candidate> findAll(int fromAge, int toAge) {
		
		List<Candidate> candidates = DatabaseMemory
				.CandadatesList
				.stream().filter( c -> c.getAge() >= fromAge && c.getAge() <= toAge)
				.collect(Collectors.toList());
		
		Collections.sort(candidates, (c1, c2) -> c1.getAge() - c2.getAge());
		return candidates;
	}
}
