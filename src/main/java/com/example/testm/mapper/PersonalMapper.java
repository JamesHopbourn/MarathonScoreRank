package com.example.testm.mapper;

import com.example.testm.entity.Personal;
import com.example.testm.entity.Team;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonalMapper {
    /**
     * 查询重复时间记录
     * @return
     */
    List<Personal> findSameNetTime();

    /**
     * 查询队伍排名
     * @return
     */
    List<Team> getTeamRank();

    /**
     * 查询个人排名
     * @param distance
     * @param gender
     * @return
     */
    List<Personal> getPersonalRank(@Param("distance") Double distance, @Param("gender") String gender);

    /**
     * 查询团队队员名字
     * @param team_name
     * @return
     */
    @Select("SELECT personal_name FROM testM WHERE team_name = #{team_name}")
    List<Personal> getTeamPersonalName(String team_name);

    /**
     * 根据性别查询分组成绩
     * @param gender
     * @return
     */
    @Select("SELECT * FROM testM WHERE gender LIKE #{gender}")
    List<Personal> getScoreByGender(String gender);

    /**
     * 更新性别分组成绩
     * @param personalList
     * @return
     */
    int updateGenderRank(List<Personal> personalList);

    /**
     * 更新个人成绩数据
     * @param personalList
     * @return
     */
    int updateOverallRank(List<Personal> personalList);
}
