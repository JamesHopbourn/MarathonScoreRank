package com.example.testm.entity;

import lombok.Data;

import java.sql.Time;

@Data
public class Team {
    /**
     * 参赛队名
     */
    private String team_name;

    /**
     * 实际用时
     */
    private Time net_time;
}
