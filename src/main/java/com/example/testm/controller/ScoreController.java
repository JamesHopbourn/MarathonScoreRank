package com.example.testm.controller;

import com.example.testm.entity.Personal;
import com.example.testm.service.ScoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.annotation.Resource;

@RestController
public class ScoreController {
    @Resource
    private ScoreService scoreService;

    @GetMapping("man")
    List<Personal> getManScore(){
        return scoreService.getManScore();
    }

    @GetMapping("woman")
    List<Personal> getWomanScore(){
        return scoreService.getWomanScore();
    }

    @GetMapping("overall")
    List<Personal> getOverallScore(){
        return scoreService.getOverallScore();
    }

    @GetMapping("team_rank")
    List<Personal> getTeamRank(){
        return scoreService.getTeamRank();
    }

    @GetMapping("team")
    List<String> getTeamPersonalName(String team_name){
        return scoreService.getTeamPersonalName(team_name);
    }

    @GetMapping("query")
    List<Personal> getPersonalRankByName(String personal_name){
        return scoreService.getPersonalRankByName(personal_name);
    }
}
