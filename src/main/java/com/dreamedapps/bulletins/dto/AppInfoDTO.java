package com.dreamedapps.bulletins.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;

import java.io.FileReader;

public class AppInfoDTO {
    public AppInfoDTO() {
    }

    @JsonProperty("version")
    public String getVersion() {
        MavenXpp3Reader mvnReader = new MavenXpp3Reader();
        try (FileReader fileReader = new FileReader("pom.xml")) {
            Model model = mvnReader.read(fileReader);
            fileReader.close();
            return model.getVersion();
        } catch (Exception e) {
            return "INVALID VERSION";
        }
    }
}
