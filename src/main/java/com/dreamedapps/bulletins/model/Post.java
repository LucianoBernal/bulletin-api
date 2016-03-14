package com.dreamedapps.bulletins.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Post {
    private long id;
    @JsonProperty("post")
    private String post;
    @JsonProperty("sender")
    private String sender;
    @JsonProperty("date")
    private long date;

    public Post(long id, String post, String sender, long date) {
        this.id = id;
        this.post = post;
        this.sender = sender;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public String getPost() {
        return post;
    }

    public String getSender() {
        return sender;
    }

    public long getDate() {
        return date;
    }

    public void setId(long id) {
        this.id = id;
    }
}
