package com.example.testm.service;

import com.example.testm.entity.Personal;
import com.example.testm.entity.Team;

import java.util.List;

public interface ScoreService {
    /**
     * 团队排名
     * @return
     */
    List<Team> getTeamRank();

    /**
     * 查询团队队员名单
     * @param team_name
     * @return
     */
    List<Personal> getTeamPersonalName(String team_name);

    /**
     * 根据名字查询成绩
     */
    List<Personal> getPersonalRankByName(String personal_name);

    /**
     * 根据性别查询分组成绩
     * @param gender
     * @return
     */
    List<Personal> getScoreByGender(String gender);

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
     * 查询重复时间记录
     * @return
     */
    List<Personal> findSameNetTime();

    /**
     * 全体排名
     * @return
     */
    List<Personal> getOverallScore();

    /**
     * 计算更新成绩
     * @param personalList
     * @return
     */
    Boolean updateGenderRank(List<Personal> personalList);
}
