package com.example.mscandidate.service;

import java.util.List;
import com.example.mscandidate.model.Candidate;

public interface JsonReadService {
	List<Candidate> readCandidatesFromJson();
}