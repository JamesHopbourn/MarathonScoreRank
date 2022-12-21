package com.example.marathon.entity;

import lombok.Data;

import java.sql.Time;
import javax.persistence.*;

@Data
@Entity
@Table(name = "data")
public class Personal {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "bigint COMMENT '主键ID'")
    private Long id;
 
    /**
     * 参赛队名
     */
    @Column(name = "team_name", nullable = false, columnDefinition = "char(20) CHARACTER SET utf8mb4 COMMENT '参赛队名'")
    private String teamName;

    /**
     * 参赛号码
     * 此处使用 String 类型 避免开头的0被忽略 也方便后续的字母扩展
     */
    @Column(name = "personal_bib", nullable = false, columnDefinition = "char(6) CHARACTER SET utf8mb4 COMMENT '参赛号码'")
    private String personalBib;

    /**
     * 参赛选手名字
     */
    @Column(name = "personal_name", nullable = false, columnDefinition = "char(4) CHARACTER SET utf8mb4 COMMENT '选手名字'")
    private String personalName;

    /**
     * 参赛选手性别
     */
    @Column(name = "gender", nullable = false, columnDefinition = "char(1) CHARACTER SET utf8mb4 COMMENT '选手性别'")
    private String gender;

    /**
     * 计时时间
     */
    @Column(name = "record_time", columnDefinition = "time COMMENT '计时时间'")
    private Time recordTime;

    /**
     * 性别排名
     */
    @Column(name = "gender_rank", columnDefinition = "int(3) COMMENT '性别排名'")
    private Integer genderRank;

    /**
     * 全体排名
     */
    @Column(name = "overall_rank", columnDefinition = "int(3) COMMENT '全体排名'")
    private Integer overallRank;

    /**
     * 视频排名
     * 用于个人计时赛近乎同时过线时通过视频区分前后
     */
    @Column(name = "video_rank", columnDefinition = "int(1) COMMENT '视频排名'")
    private Integer videoRank;

    /**
     * 实际用时
     */
    @Column(name = "net_time", columnDefinition = "time COMMENT '平均配速'")
    private Time netTime;

    /**
     * 平均配速
     */
    @Column(name = "avg_pace", columnDefinition = "char(6) CHARACTER SET utf8mb4 COMMENT '平均配速'")
    private String avgPace;

    /**
     * 成绩排名
     */
    @Transient
    private Integer rank;
}
