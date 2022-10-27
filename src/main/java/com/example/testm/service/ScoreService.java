package com.example.testm.service;

import com.example.testm.common.resp.PersonalResp;
import com.example.testm.entity.Personal;

import java.util.List;

public interface ScoreService {
    /**
     * 查询个人整体数据
     * @return
     */
    List<PersonalResp> getPersonalData();

    /**
     * 团队排名
     * @return
     */
    List<Personal> getTeamRank();

    /**
     * 查询团队队员名单
     * @param team_name
     * @return
     */
    List<String> getTeamPersonalName(String team_name);

    /**
     * 根据名字查询成绩
     */
    List<Personal> getPersonalRankByName(String personal_name);

    /**
     * 男子组排名
     * @return
     */
    List<Personal> getManScore();

    /**
     * 女子组排名
     * @return
     */
    List<Personal> getWomanScore();

    /**
     * 全体排名
     * @return
     */
    List<Personal> getOverallScore();
}
