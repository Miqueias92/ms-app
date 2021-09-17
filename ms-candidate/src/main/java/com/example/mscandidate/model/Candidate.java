package com.example.mscandidate.model;

import java.time.LocalDate;
import java.time.Period;

import lombok.Getter;

@Getter
public class Candidate {
	private String id;
	private String name;
	private String jobOpportunity;
	private LocalDate birthDate;
	private int age;
	
	@Getter
	public static class Builder {
		
		private String id;
		private String name;
		private String jobOpportunity;
		private LocalDate birthDate;
		
		public Builder id(String id) {
			this.id = id;
			return this;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder jobOpportunity(String jobOpportunity) {
			this.jobOpportunity = jobOpportunity;
			return this;
		}
		
		public Builder birthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
			return this;
		}
		
		public Candidate build() {
			return new Candidate(this);
		}
	}
	
	private Candidate(Builder builder) {
		this.id = builder.getId();
		this.name = builder.getName();
		this.jobOpportunity = builder.getJobOpportunity();
		this.birthDate = builder.birthDate;
		this.age = calculateAge(builder.birthDate);
	}
	
	public int calculateAge(LocalDate birthDate) {
		LocalDate actual = LocalDate.now();
		return Period.between(birthDate, actual).getYears();
	}
}