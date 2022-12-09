package com.example.testm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.testm.entity.Personal;
import com.example.testm.entity.Team;
import com.example.testm.service.ScoreService;
import com.example.testm.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestMApplicationTests {
    @Resource
    private ScoreService scoreService;
    @Resource
    private TeamService teamService;

    @Test
    @Order(1)
    void updateScoreData(){
        // 计算更新男子性别分组成绩
        List<Personal> manScore = scoreService.getManScore();
        Boolean manBoolean = scoreService.updateGenderRank(manScore);
        log.info(manBoolean.toString());

        // 计算更新女子性别分组成绩
        List<Personal> womanScore = scoreService.getWomanScore();
        Boolean womanBoolean = scoreService.updateGenderRank(womanScore);
        log.info(womanBoolean.toString());

        // 计算更新全体排名、平均速度
        List<Personal> overallScore = scoreService.getOverallScore();
        Boolean overallBoolean = scoreService.updateOverallRank(overallScore);
        log.info(overallBoolean.toString());
    }

    @Test
    @Order(2)
    void select(){
        List<Team> teamRank = scoreService.getTeamRank();
        for (Team team : teamRank) {
            teamService.save(team);
        }
    }

    @Test
    @Order(3)
    void findSameNetTime(){
        List<Personal> sameNetTime = scoreService.findSameNetTime();
        Time netTime = sameNetTime.get(0).getNetTime();
        for(Personal personal : sameNetTime){
            if (!Objects.equals(personal.getNetTime(), netTime)){
                netTime = personal.getNetTime();
                System.out.println();
            }
            System.out.println(personal);
        }
    }

    @Test
    @Order(4)
    void print(){
        JSONObject.DEFFAULT_DATE_FORMAT="HH:mm:ss";
        List<Team> teamRank = scoreService.getTeamRank();
        String jsonString = JSON.toJSONString(teamRank, SerializerFeature.PrettyFormat, SerializerFeature.WriteDateUseDateFormat);
        System.out.println(jsonString);
    }
}
