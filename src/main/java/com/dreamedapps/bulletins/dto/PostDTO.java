package com.dreamedapps.bulletins.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostDTO {
    @JsonProperty("id")
    private long id;
    @JsonProperty("post")
    private String post;
    @JsonProperty("sender")
    private String sender;
    @JsonProperty("date")
    private long date;

    public PostDTO(long id, String post, String sender, long date) {
        this.id = id;
        this.post = post;
        this.sender = sender;
        this.date = date;
    }
}
