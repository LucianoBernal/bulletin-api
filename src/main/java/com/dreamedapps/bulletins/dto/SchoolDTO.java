package com.dreamedapps.bulletins.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SchoolDTO {
	@JsonProperty("code")
	private String code;

	@JsonProperty("name")
	private String name;

	@JsonProperty("grades")
	private List<GradesDTO> grades;

	public SchoolDTO(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public List<GradesDTO> getGrades() {
		return grades;
	}
}
