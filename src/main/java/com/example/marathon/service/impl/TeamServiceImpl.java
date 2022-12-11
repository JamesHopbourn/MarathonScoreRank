package com.example.marathon.service.impl;

import com.example.marathon.entity.Team;
import com.example.marathon.mapper.TeamMapper;
import com.example.marathon.service.TeamService;
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
