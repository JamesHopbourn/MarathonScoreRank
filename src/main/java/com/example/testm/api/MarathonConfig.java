package com.example.testm.api;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Data
@Configuration
public class MarathonConfig {
    @Value("${marathon.github-token}")
    private String githubToken;

    @Value("${marathon.github-json-path}")
    private String githubJsonPath;

    @PostConstruct
    public void init(){
        MarathonUtil.setConfigInfo(this);
    }
}