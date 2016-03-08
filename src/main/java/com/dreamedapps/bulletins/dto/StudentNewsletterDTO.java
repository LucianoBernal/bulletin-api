package com.dreamedapps.bulletins.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class StudentNewsletterDTO {
    @JsonProperty("posts")
    List<PostDTO> posts;

    public StudentNewsletterDTO() {
        this.posts = new ArrayList<>();
    }

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void addPost(PostDTO malanota) {
        this.posts.add(malanota);
    }
}
