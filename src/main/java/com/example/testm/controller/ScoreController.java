package com.example.testm.controller;

import com.example.testm.common.resp.PersonalResp;
import com.example.testm.entity.Personal;
import com.example.testm.entity.Team;
import com.example.testm.service.ScoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.annotation.Resource;

@RestController
public class ScoreController {
    @Resource
    private ScoreService scoreService;

    /**
     * 查看全体人员数据
     * @return
     */
    @GetMapping("overall")
    List<PersonalResp> getOverallScore(){
        return scoreService.getPersonalData();
    }

    /**
     * 制定查询某人比赛成绩
     * @param personal_name
     * @return
     */
    @GetMapping("query")
    List<Personal> getPersonalRankByName(String personal_name){
        return scoreService.getPersonalRankByName(personal_name);
    }

    /**
     * 查询团队排名
     * @return
     */
    @GetMapping("team")
    List<Team> getTeamRank(){
        return scoreService.getTeamRank();
    }

    /**
     * 查询团队成员
     * @param team_name
     * @return
     */
    @GetMapping("member")
    List<Personal> getTeamPersonalName(String team_name){
        return scoreService.getTeamPersonalName(team_name);
    }
}
