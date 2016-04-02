package com.dreamedapps.bulletins.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SchoolEntryDTO {
	@JsonProperty("name")
	private String name;

	@JsonProperty("code")
	private String code;

	public SchoolEntryDTO(String name, String code) {
		this.name = name;
		this.code = code;
	}

	public SchoolEntryDTO() {}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}
}
