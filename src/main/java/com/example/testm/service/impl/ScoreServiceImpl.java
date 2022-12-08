package com.example.testm.service.impl;

import com.example.testm.entity.Personal;
import com.example.testm.entity.Team;
import com.example.testm.mapper.PersonalMapper;
import com.example.testm.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class ScoreServiceImpl implements ScoreService {
    @Resource
    private PersonalMapper personalMapper;

    @Override
    public List<Personal> getManScore() {
        List<Personal> manScore = personalMapper.getPersonalRank("男");
        log.info(manScore.toString());
        return manScore;
    }

    @Override
    public List<Personal> getWomanScore() {
        List<Personal> WomanScore = personalMapper.getPersonalRank("女");
        log.info(WomanScore.toString());
        return WomanScore;
    }

    @Override
    public List<Personal> findSameNetTime() {
        return personalMapper.findSameNetTime();
    }

    @Override
    public List<Personal> getOverallScore() {
        List<Personal> OverallScore = personalMapper.getPersonalRank("%");
        log.info(OverallScore.toString());
        return OverallScore;
    }

    @Override
    public Boolean updateOverallRank(List<Personal> overallScore) {
        int i = personalMapper.updateOverallRank(overallScore);
        return i == 1;
    }

    @Override
    public Boolean updateGenderRank(List<Personal> personalList) {
        int i = personalMapper.updateGenderRank(personalList);
        return i == 1;
    }

    @Override
    public List<Team> getTeamRank() {
        List<Team> teamRank = personalMapper.getTeamRank();
        log.info(teamRank.toString());
        return teamRank;
    }

    @Override
    public List<Personal> getScoreByGender(String gender) {
        List<Personal> scoreByGender = personalMapper.getScoreByGender(gender);
        log.info(scoreByGender.toString());
        return scoreByGender;
    }

    @Override
    public List<Personal> getTeamPersonalName(String team_name) {
        List<Personal> teamPersonalName = personalMapper.getTeamPersonalName(team_name);
        log.info(teamPersonalName.toString());
        return teamPersonalName;
    }

    @Override
    public List<Personal> getPersonalRankByName(String personal_name) {
        ArrayList<Personal> result = new ArrayList<>();
        List<Personal> overallScore = this.getOverallScore();
        for (Personal item : overallScore){
            if (Objects.equals(item.getPersonalName(), personal_name)){
                result.add(item);
            }
        }
        log.info(result.toString());
        return result;
    }
}
