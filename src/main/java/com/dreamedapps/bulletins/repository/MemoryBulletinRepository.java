package com.dreamedapps.bulletins.repository;

import com.dreamedapps.bulletins.model.Post;
import com.dreamedapps.bulletins.model.School;
import com.dreamedapps.bulletins.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryBulletinRepository implements BulletinRepository{
    private List<Student> allStudents;
    private Map<Long,List<Post>> allNewsletters;
    private Long postIds;
    private long lastSchoolId;

    public MemoryBulletinRepository() {
        this.allStudents = new ArrayList<>();
        this.allNewsletters = new HashMap<>();
        this.postIds = 0l;
        this.lastSchoolId = 0l;
    }

    @Override
    public Student getStudentInfo(long studentId) throws RuntimeException {
        return allStudents.stream()
                .filter(student -> student.getId() == studentId)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Student createStudent(Student student) {
        allStudents.add(student);
        return student;
    }

    @Override
    public List<Post> getStudentNewsletter(long studentId) {
        if(allNewsletters.containsKey(studentId)){
            return allNewsletters.get(studentId);
        }
        return new ArrayList<>();
    }

    @Override
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

    @Override
    public School createSchool(String name, String code) {
        return new School(code, name);
    }
}
