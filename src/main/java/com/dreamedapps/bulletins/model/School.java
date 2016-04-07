package com.dreamedapps.bulletins.model;

import java.util.List;

public class School {
	private String code;
	private String name;
	private List<Grades> grades;

	public School(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {

		return code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
