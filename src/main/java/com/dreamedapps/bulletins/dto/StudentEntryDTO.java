package com.dreamedapps.bulletins.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

public class StudentEntryDTO {
	@ApiModelProperty(required = true) @JsonProperty("id") private long id;

	@ApiModelProperty(required = true) @JsonProperty("name") private String name;

	@ApiModelProperty(required = true) @JsonProperty("school") private String school;

	@ApiModelProperty(required = true) @JsonProperty("grade") private String grade;

	@ApiModelProperty(required = true) @JsonProperty("course") private String course;

	@ApiModelProperty(required = true) @JsonProperty("surname") private String surname;

	@ApiModelProperty(required = true) @JsonProperty("moreInfo") private String moreInfo;

	public StudentEntryDTO(){
		//FOR JACKSON DESERIALIZATION
	}

	public StudentEntryDTO(long id, String course, String grade, String moreInfo, String name, String school, String surname) {
		this.id = id;
		this.course = course;
		this.grade = grade;
		this.moreInfo = moreInfo;
		this.name = name;
		this.school = school;
		this.surname = surname;
	}

	public String getCourse() {
		return course;
	}

	public String getGrade() {
		return grade;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public String getSchool() {
		return school;
	}

	public String getSurname() {
		return surname;
	}
}
