package com.dreamedapps.bulletins.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentDTO {
    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("school")
    private String school;
    @JsonProperty("grade")
    private String grade;
    @JsonProperty("course")
    private String course;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("more_info")
    private String moreInfo;

    public StudentDTO(String name, String school, String grade, String course) {
        this.surname = "";
        this.moreInfo= "";
        this.name = name;
        this.school = school;
        this.grade = grade;
        this.course = course;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public String getGrade() {
        return grade;
    }

    public String getCourse() {
        return course;
    }

    public String getSurname() {
        return surname;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }
}
