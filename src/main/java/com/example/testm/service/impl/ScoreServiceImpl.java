package com.example.testm.service.impl;

import com.example.testm.common.resp.PersonalResp;
import com.example.testm.entity.Personal;
import com.example.testm.mapper.PersonalMapper;
import com.example.testm.service.ScoreService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ScoreServiceImpl implements ScoreService {
    /**
     * 赛事距离
     */
    @Value("${marathon.distance}")
    private Double DISTANCE;

    @Resource
    private PersonalMapper personalMapper;

    @Override
    public List<Personal> getManScore() {
        List<Personal> manScore = personalMapper.getPersonalRank(DISTANCE, "男");
        return manScore;
    }

    @Override
    public List<Personal> getWomanScore() {
        List<Personal> WomanScore = personalMapper.getPersonalRank(DISTANCE, "女");
        return WomanScore;
    }

    @Override
    public List<Personal> getOverallScore() {
        List<Personal> OverallScore = personalMapper.getPersonalRank(DISTANCE, "%");
        return OverallScore;
    }

    @Override
    public List<PersonalResp> getPersonalData() {
        return personalMapper.getPersonalData();
    }

    @Override
    public List<Personal> getTeamRank() {
        List<Personal> teamRank = personalMapper.getTeamRank();
        return teamRank;
    }

    @Override
    public List<String> getTeamPersonalName(String team_name) {
        return personalMapper.getTeamPersonalName(team_name);
    }

    @Override
    public List<Personal> getPersonalRankByName(String personal_name) {
        ArrayList<Personal> result = new ArrayList<>();
        List<Personal> overallScore = this.getOverallScore();
        for (Personal item : overallScore){
            if (Objects.equals(item.getPersonal_name(), personal_name)){
                result.add(item);
            }
        }
        return result;
    }
}
