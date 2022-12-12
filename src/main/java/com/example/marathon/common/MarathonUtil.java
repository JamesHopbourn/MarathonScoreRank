package com.example.marathon.common;

import lombok.Data;

@Data
public class MarathonUtil {
    private static String GithubToken;
    private static String GithubBranch;
    private static String GithubJsonPath;

    public static void setConfigInfo(MarathonConfig marathonConfig) {
        MarathonUtil.GithubToken = marathonConfig.getGithubToken();
        MarathonUtil.GithubBranch = marathonConfig.getGithubBranch();
        MarathonUtil.GithubJsonPath = marathonConfig.getGithubJsonPath();
    }

    public static String getGithubToken(){
        return GithubToken;
    }

    public static String getGithubBranch(){
        return GithubBranch;
    }

    public static String getGithubJsonPath(){
        return GithubJsonPath;
    }
}