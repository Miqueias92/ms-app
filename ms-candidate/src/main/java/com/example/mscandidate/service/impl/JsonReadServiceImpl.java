package com.example.mscandidate.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.springframework.stereotype.Service;

import com.example.mscandidate.model.Candidate;
import com.example.mscandidate.service.JsonReadService;
import com.example.mscandidate.util.DateUtil;

@Service
public class JsonReadServiceImpl implements JsonReadService {

	@Override
	public List<Candidate> readCandidatesFromJson() {
		List<Candidate> candidates = new ArrayList<>();
		Optional<InputStream> stream = readJsonFile();
		
		if (stream.isPresent()) {
			JsonArray jsonCandidates = getCandidates(stream);
			jsonCandidates.forEach(jCandidate ->{
				Candidate candidate = buildCandidate(jCandidate.asJsonObject()); 
				candidates.add(candidate);
			});
		}
		return candidates;
	}

	private Optional<InputStream> readJsonFile() {
		try {
			InputStream istream = getClass().getResourceAsStream("/file/candidatos.json");
			return Optional.of(istream);
		} catch (Exception e) {
			e.printStackTrace();
			return Optional.ofNullable(null);
		}
	}
	
	private JsonArray getCandidates(Optional<InputStream> stream) {
		JsonReader jsonReader = Json.createReader(stream.get());
		JsonObject jsonRecruiter = jsonReader.readObject();
		jsonReader.close();
		JsonArray jsonCandidates = jsonRecruiter.getJsonArray("candidatos");
		return jsonCandidates;
	}
	
	private Candidate buildCandidate(JsonObject json) {
		return new Candidate
				.Builder()
				.id(json.getString("_id"))
				.name(json.getString("nome"))
				.jobOpportunity(json.getString("vaga"))
				.birthDate(DateUtil.toLocalDate(json.getString("data_nascimento")))
				.build();
	}
}