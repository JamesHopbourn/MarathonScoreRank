package com.example.marathon.entity;

import lombok.Data;

import java.sql.Time;
import javax.persistence.*;

@Data
@Entity
@Table(name = "team")
public class Team {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "bigint COMMENT '主键ID'")
    private Long id;

    /**
     * 团队排名
     */
    @Column(name = "team_rank", nullable = false, columnDefinition = "int(2) COMMENT '团队排名'")
    private String teamRank;

    /**
     * 团队名字
     */
    @Column(name = "team_name", nullable = false, columnDefinition = "char(20) CHARACTER SET utf8mb4 COMMENT '团队名字'")
    private String teamName;

    /**
     * 团队时间
     */
    @Column(name = "net_time", nullable = false, columnDefinition = "time COMMENT '团队总时间'")
    private Time netTime;
}
