package com.example.testm.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class PersonalMapperTest {
    @Resource
    private PersonalMapper personalMapper;

    @Test
    void getTeamRank(){
        System.out.println(personalMapper.getTeamRank());
    }
}