package com.dreamedapps.bulletins.service;

import com.dreamedapps.bulletins.dto.PostDTO;
import com.dreamedapps.bulletins.dto.StudentEntryDTO;
import com.dreamedapps.bulletins.dto.StudentNewsletterDTO;
import com.dreamedapps.bulletins.dto.StudentDTO;
import com.dreamedapps.bulletins.model.Student;
import com.dreamedapps.bulletins.repository.BulletinRepository;

import java.util.Date;
import java.util.List;

public class StudentService {
    private BulletinRepository repository;

    public StudentService(BulletinRepository repository) {
        this.repository = repository;
    }

    public StudentDTO getStudentInfo(long studentId) {
        Student student = repository.getStudentInfo(studentId);
        StudentDTO studentDTO = createStudentDTOfromStudent(student);
        studentDTO.setId(studentId);
        return studentDTO;
    }

    public StudentDTO createStudent(StudentEntryDTO studentDTO) {
        Student student = createStudentfromEntryDTO(studentDTO);
        Student savedStudent = repository.createStudent(student);
        return createStudentDTOfromStudent(savedStudent);
    }

    private Student createStudentfromEntryDTO(StudentEntryDTO studentEntryDTO) {
        String course = studentEntryDTO.getCourse();
        String grade = studentEntryDTO.getGrade();
        String moreInfo = studentEntryDTO.getMoreInfo();
        String name = studentEntryDTO.getName();
        String school = studentEntryDTO.getSchool();
        String surname = studentEntryDTO.getSurname();

        Student student = new Student(name, school, grade, course);
        student.setSurname(surname);
        student.setMoreProfileInfo(moreInfo);
        return student;
    }

    private StudentDTO createStudentDTOfromStudent(Student student) {
        long studentId = student.getId();
        String name = student.getName();
        String surname = student.getSurname();
        String course = student.getCourse();
        String grade = student.getGrade();
        String school = student.getSchool();
        String moreProfileInfo = student.getMoreProfileInfo();
        StudentDTO studentDTO = new StudentDTO(name, school, grade, course);
        studentDTO.setSurname(surname);
        studentDTO.setMoreInfo(moreProfileInfo);
        studentDTO.setId(studentId);
        return studentDTO;
    }

    public StudentNewsletterDTO getNewsletter(long studentId) {
        PostDTO malanota = new PostDTO(1l, "malanota", "Profe Forro", new Date().getTime());
        StudentNewsletterDTO newsletter = new StudentNewsletterDTO();
        newsletter.addPost(malanota);
        return newsletter;
        //TODO: must implement
    }
}
