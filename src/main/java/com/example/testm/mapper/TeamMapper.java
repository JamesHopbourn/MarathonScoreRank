package com.example.testm.mapper;

import com.example.testm.entity.Team;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TeamMapper {
    @Insert("INSERT INTO team(team_rank, team_name, net_time) VALUES (#{t.team_rank}, #{t.team_name}, #{t.net_time})")
    void insert(@Param("t") Team team);
}
