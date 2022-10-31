package com.example.testm.controller;

import com.netflix.graphql.dgs.DgsQueryExecutor;
import graphql.ExecutionResult;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/v1")
public class PersonalController {
    @Resource
    private DgsQueryExecutor dgsQueryExecutor;

    @PostMapping("personals")
    public JSONArray personals(@RequestBody JSONObject body){
        JSONArray execute = dgsQueryExecutor.executeAndExtractJsonPath(body.getAsString("query"), "data.personals");
        return execute;
    }

    @PostMapping("teams")
    public JSONArray teams(@RequestBody JSONObject body){
        JSONArray execute = dgsQueryExecutor.executeAndExtractJsonPath(body.getAsString("query"), "data.teams");
        return execute;
    }
}
