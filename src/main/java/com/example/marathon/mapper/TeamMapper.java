package com.example.marathon.mapper;

import com.example.marathon.entity.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TeamMapper {
    void insert(@Param("t") Team team);
}
