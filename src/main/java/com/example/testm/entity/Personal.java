package com.example.testm.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personal {
    /**
     * 参赛队名
     */
    private String teamName;

    /**
     * 参赛号码
     * 此处使用 String 类型 避免开头的0被忽略 也方便后续的字母扩展
     */
    private String personalBib;

    /**
     * 参赛选手名字
     */
    private String personalName;

    /**
     * 参赛选手性别
     */
    private String gender;

    /**
     * 计时时间
     */
    private Time recordTime;

    /**
     * 性别排名
     */
    private Integer genderRank;

    /**
     * 全体排名
     */
    private Integer overallRank;

    /**
     * 视频排名
     * 用于个人计时赛近乎同时过线时通过视频区分前后
     */
    private Integer videoRank;

    /**
     * 实际用时
     */
    private Time netTime;

    /**
     * 配速
     */
    private String avgPace;

    /**
     * 成绩排名
     */
    private Integer rank;
}
