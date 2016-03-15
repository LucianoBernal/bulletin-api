package com.dreamedapps.bulletins.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SchoolEntryDTO {
	@JsonProperty("name")
	private String name;

	public SchoolEntryDTO(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
