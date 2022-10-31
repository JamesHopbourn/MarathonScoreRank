package com.example.testm.component;

import com.example.testm.entity.Personal;
import com.example.testm.entity.Team;
import com.example.testm.service.ScoreService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import javax.annotation.Resource;
import java.util.List;

@DgsComponent
public class DgsController {
    @Resource
    private ScoreService scoreService;

    /*
     curl 'http://localhost:8080/graphql' \
        -H 'Content-Type: application/json' \
        --data-raw '{"query":"{personals(query: \"overall\"){team_name, personal_bib, personal_name, gender, record_time, gender_rank, overall_rank, net_time, avg_pace}}"}'
    */
    @DgsQuery
    public List<Personal> personals(@InputArgument String query, @InputArgument String value){
        switch (query) {
            case "male":
                return scoreService.getScoreByGender("男");
            case "female":
                return scoreService.getScoreByGender("女");
            case "overall":
                return scoreService.getScoreByGender("%");
            case "same":
                return scoreService.findSameNetTime();
            case "members":
                return scoreService.getTeamPersonalName(value);
            case "detail":
                return scoreService.getPersonalRankByName(value);
        }
        return null;
    }

    /*
     curl -X "POST" "http://localhost:8080/graphql" \
          -H 'Content-Type: text/plain; charset=utf-8' \
          -d '{"query":"{teams{team_name,rank,net_time}}"}'
    */
    @DgsQuery
    public List<Team> teams(){
            return scoreService.getTeamRank();
    }
}
