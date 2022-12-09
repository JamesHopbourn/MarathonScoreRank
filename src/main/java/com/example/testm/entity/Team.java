package com.example.testm.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Data
@Entity
@Table(name = "team")
public class Team implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "bigint(20) COMMENT '主键ID'")
    private Long id;

    @Column(name = "team_rank", nullable = false, columnDefinition = "int(2) COMMENT '团队排名'")
    private String teamRank;

    @Column(name = "team_name", nullable = false, columnDefinition = "char(20) CHARACTER SET utf8mb4 COMMENT '用户名'")
    private String teamName;

    @Column(name = "net_time", nullable = false, columnDefinition = "time COMMENT '团队总时间'")
    private Time netTime;
}
