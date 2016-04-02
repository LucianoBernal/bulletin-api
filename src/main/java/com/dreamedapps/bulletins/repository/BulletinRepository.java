package com.dreamedapps.bulletins.repository;

import com.dreamedapps.bulletins.model.Post;
import com.dreamedapps.bulletins.model.School;
import com.dreamedapps.bulletins.model.Student;

import java.util.List;

public interface BulletinRepository {
    Student getStudentInfo(long studentId) throws RuntimeException;
    Student createStudent(Student student);
    List<Post> getStudentNewsletter(long studentId);
    Post postCommunication(long studentId, Post post);
    School createSchool(String name, String code);

}
