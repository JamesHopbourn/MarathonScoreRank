package com.example.testm.entity;

import lombok.Data;

import java.sql.Time;

@Data
public class Team {
    /**
     * 团队排名
     */
    private Integer teamRank;

    /**
     * 参赛队名
     */
    private String teamName;

    /**
     * 实际用时
     */
    private Time netTime;
}
