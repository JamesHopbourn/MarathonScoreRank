package com.example.testm.mapper;

import com.example.testm.entity.Personal;
import com.example.testm.entity.Team;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

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
     * @param gender
     * @return
     */
    List<Personal> getPersonalRank(String gender);

    /**
     * 查询团队队员名字
     * @param teamName
     * @return
     */
    List<Personal> getTeamPersonalName(String teamName);

    /**
     * 根据性别查询分组成绩
     * @param gender
     * @return
     */
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
