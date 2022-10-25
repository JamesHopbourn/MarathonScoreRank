package com.example.testm.entity;

import lombok.Data;

import java.sql.Time;

@Data
public class Personal {
    /**
     * 赛事名称
     */
    private String event;

    /**
     * 参赛队名
     */
    private String team_name;

    /**
     * 参赛号码
     */
    private Integer personal_id;

    /**
     * 参赛选手名字
     */
    private String personal_name;

    /**
     * 参赛选手性别
     */
    private String sex;

    /**
     * 计时时间
     */
    private Time record_time;

    /**
     * 视频排名 用于近乎同时过线时通过视频区分前后
     */
    private Integer video_rank;

    /**
     * 实际用时
     */
    private Time net_time;

    /**
     * 配速
     */
    private String avg_speed;
}
