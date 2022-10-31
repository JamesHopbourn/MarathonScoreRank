package com.example.testm.controller;

import com.netflix.graphql.dgs.DgsQueryExecutor;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class DgsControllerTest {
    @Resource
    DgsQueryExecutor dgsQueryExecutor;

    @Test
    void shows() {
        JSONArray execute = dgsQueryExecutor.executeAndExtractJsonPath("{personals(query: \"overall\"){personal_bib personal_name gender record_time gender_rank net_time avg_pace}}",
                "data.personals");
        System.out.println(execute);
    }
}