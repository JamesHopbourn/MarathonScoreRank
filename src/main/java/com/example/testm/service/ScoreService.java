package com.example.testm.service;

import com.example.testm.entity.Personal;

import java.util.List;

public interface ScoreService {
    /**
     * 团队排名
     * @return
     */
    List<Personal> getTeamRank();

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
