package com.dreamedapps.bulletins.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SchoolDTO {
	@JsonProperty("id")
	private long id;

	@JsonProperty("name")
	private String name;

	private List<GradesDTO> grades;

	public SchoolDTO(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public void setGrades(List<GradesDTO> grades) {
		this.grades = grades;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<GradesDTO> getGrades() {
		return grades;
	}
}
