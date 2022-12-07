package com.example.testm.mapper;

import com.example.testm.entity.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TeamMapper {
    void insert(@Param("t") Team team);
}
