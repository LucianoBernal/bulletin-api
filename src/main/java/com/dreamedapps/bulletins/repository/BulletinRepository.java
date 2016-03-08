package com.dreamedapps.bulletins.repository;

import com.dreamedapps.bulletins.dto.StudentDTO;
import com.dreamedapps.bulletins.exception.StudentDoesntExist;
import com.dreamedapps.bulletins.model.Student;

import java.util.ArrayList;
import java.util.List;

public class BulletinRepository {
    private List<Student> allStudents;

    public BulletinRepository() {
        this.allStudents = new ArrayList<>();

        addAStudentToStudentsList();
    }

    public Student getStudentInfo(long studentId) throws RuntimeException{
            return allStudents.stream()
                    .filter(student -> student.getId() == studentId)
                    .findFirst()
                    .orElseThrow(StudentDoesntExist::new);
    }

    private void addAStudentToStudentsList() {
        long id = 1l;
        Student stud = new Student(id,"a","a","a","a");
        this.allStudents.add(stud);
    }

    public Student createStudent(Student student) {
        //long id = dao.createStudent();
        student.setId(2l);
        return student;
    }
}
