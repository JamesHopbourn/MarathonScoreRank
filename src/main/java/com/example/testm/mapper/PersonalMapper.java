package com.example.testm.mapper;

import com.example.testm.entity.Personal;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonalMapper {
    /**
     * 查询队伍排名
     * @return
     */
    List<Personal> getTeamRank();

    /**
     * 查询团队队员名字
     * @param team_name
     * @return
     */
    @Select("SELECT personal_name FROM testM WHERE team_name = #{team_name}")
    List<String> getTeamPersonalName(String team_name);

    /**
     * 查询个人排名
     * @param distance
     * @param gender
     * @return
     */
    List<Personal> getPersonalRank(@Param("distance") Double distance, @Param("gender") String gender);
}
