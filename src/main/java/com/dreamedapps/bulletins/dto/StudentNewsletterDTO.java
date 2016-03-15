package com.dreamedapps.bulletins.dto;

import com.dreamedapps.bulletins.model.Post;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class StudentNewsletterDTO {
    @JsonProperty("posts")
    List<Post> posts;

    public StudentNewsletterDTO() {
        this.posts = new ArrayList<>();
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public void addPosts(List<Post> studentPosts) {
        this.posts = studentPosts;
    }
}
