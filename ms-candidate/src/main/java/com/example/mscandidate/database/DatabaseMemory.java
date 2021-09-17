package com.example.mscandidate.database;

import java.util.ArrayList;
import java.util.List;

import com.example.mscandidate.model.Candidate;

public class DatabaseMemory {
	
	public static List<Candidate> CandadatesList;
	
	static {
		CandadatesList = new ArrayList<Candidate>();
	}
}
