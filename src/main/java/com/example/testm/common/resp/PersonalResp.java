package com.example.testm.common.resp;

import lombok.Data;

import java.sql.Time;

@Data
public class PersonalResp {
    /**
     * 参赛号码
     * 此处使用 String 类型 避免开头的0被忽略 也方便后续的字母扩展
     */
    private String personal_id;

    /**
     * 参赛选手名字
     */
    private String personal_name;

    /**
     * 参赛选手性别
     */
    private String gender;

    /**
     * 计时时间
     */
    private Time record_time;

    /**
     * 性别排名
     */
    private Integer gender_rank;

    /**
     * 全体排名
     */
    private Integer overall_rank;

    /**
     * 实际用时
     */
    private Time net_time;

    /**
     * 配速
     */
    private String avg_pace;
}
