package com.example.testm.mapper;

import com.example.testm.entity.Personal;
import com.example.testm.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class PersonalMapperTest {
    @Resource
    private ScoreService scoreService;
    @Resource
    private PersonalMapper personalMapper;

    @Test
    void getTeamRank(){
        List<Personal> personalList = personalMapper.findSameNetTime();
        personalList.forEach(System.out::println);
    }

    @Test
    void updateScoreData(){
        // 更新男子性别分组成绩
        List<Personal> manScore = scoreService.getManScore();
        log.info(String.valueOf(personalMapper.updateGenderRank(manScore) == 1));

        // 更新女子性别分组成绩
        List<Personal> womanScore = scoreService.getWomanScore();
        log.info(String.valueOf(personalMapper.updateGenderRank(womanScore) == 1));

        // 更新全体排名、平均速度
        List<Personal> overallScore = scoreService.getOverallScore();
        log.info(String.valueOf(personalMapper.updateOverallRank(overallScore) == 1));
    }
}