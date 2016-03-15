package com.dreamedapps.bulletins.model;

public class Student {
    private long id;
    private String name;
    private String surname;
    private String school;
    private String grade;
    private String course;
    private String moreProfileInfo = "burundanga";

    public Student(long id, String name, String school, String grade, String course) {
        this.id = id;
        this.name = name;
        this.school = school;
        this.grade = grade;
        this.course = course;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
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

    public String getMoreProfileInfo() {
        return moreProfileInfo;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMoreProfileInfo(String moreProfileInfo) {
        this.moreProfileInfo = moreProfileInfo;
    }

}
