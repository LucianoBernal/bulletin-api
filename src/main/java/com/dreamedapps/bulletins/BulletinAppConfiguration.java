package com.dreamedapps.bulletins;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class BulletinAppConfiguration extends Configuration{
    @JsonProperty("database")
    @NotNull
    @Valid
    private String database;

    public String getDatabase() {
        return database;
    }
}
