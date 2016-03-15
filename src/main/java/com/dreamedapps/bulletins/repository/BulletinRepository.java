package com.dreamedapps.bulletins.repository;

import com.dreamedapps.bulletins.model.Post;
import com.dreamedapps.bulletins.model.School;
import com.dreamedapps.bulletins.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BulletinRepository {
    private List<Student> allStudents;
    private Map<Long,List<Post>> allNewsletters;
    private Long postIds;
    private long lastSchoolId;

    public BulletinRepository() {
        this.allStudents = new ArrayList<>();
        this.allNewsletters = new HashMap<>();
        this.postIds = 0l;
        this.lastSchoolId = 0l;
    }

    public Student getStudentInfo(long studentId) throws RuntimeException {
        return allStudents.stream()
                .filter(student -> student.getId() == studentId)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public Student createStudent(Student student) {
        allStudents.add(student);
        return student;
    }

    public List<Post> getStudentNewsletter(long studentId) {
        if(allNewsletters.containsKey(studentId)){
            return allNewsletters.get(studentId);
        }
        return new ArrayList<>();
    }

    public Post postCommunication(long studentId, Post post) {
        post.setId(generatePostId());
        if(allNewsletters.containsKey(studentId)) {
            allNewsletters.get(studentId).add(post);
        } else {
            List<Post> posts = new ArrayList<>();
            posts.add(post);
            allNewsletters.put(studentId,posts);
        }
        return post;
    }

    private long generatePostId() {
        return postIds+1;
    }

    public School createSchool(String name) {
        long id = lastSchoolId +=1;
        return new School(id,name);
    }
}
