package com.example.testm.service.impl;

import com.example.testm.entity.Team;
import com.example.testm.mapper.TeamMapper;
import com.example.testm.service.TeamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeamServiceImpl implements TeamService {
    @Resource
    private TeamMapper teamMapper;

    @Override
    public void save(Team team) {
        teamMapper.insert(team);
    }
}
