package com.example.testm.api;

import lombok.Data;

@Data
public class MarathonUtil {
    private static String GithubToken;
    private static String GithubJsonPath;

    public static void setConfigInfo(MarathonConfig marathonConfig) {
        MarathonUtil.GithubToken = marathonConfig.getGithubToken();
        MarathonUtil.GithubJsonPath = marathonConfig.getGithubJsonPath();
    }

    public static String getGithubToken(){
        return GithubToken;
    }

    public static String getGithubJsonPath(){
        return GithubJsonPath;
    }
}