package com.taocares.dispatch.service;

import com.taocares.dispatch.dto.TeamDto;
import com.taocares.dispatch.dto.UserTeamDto;
import com.taocares.dispatch.entity.Team;
import com.taocares.dispatch.entity.UserTeam;
import com.taocares.dispatch.utils.Return;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * 班组Service
 *
 * @author qinkai
 * @date 2018/09/30
 */
public interface TeamService {

    /**
     * 保存或更新班组
     *
     * @param teamDto
     * @return void
     */
    void saveOrUpdateTeam(TeamDto teamDto);

    /**
     * 根据条件查询班组
     *
     * @param params
     * @return org.springframework.data.domain.Page<com.taocares.dispatch.dto.TeamDto>
     */
    Page<TeamDto> listTeam(Map<String, String> params);

    /**
     * 根据id查询班组
     *
     * @param id
     * @return com.taocares.dispatch.dto.TeamDto
     */
    TeamDto getTeamById(Integer id);

    /**
     * 删除班组
     *
     * @param id
     * @return void
     */
    void removeTeam(Integer id);

    /**
     * 删除用户班组
     *
     * @param id
     * @return void
     */
    void removeUserTeam(Integer id);

    /**
     * 保存用户班组
     *
     * @param userTeamDto
     * @return void
     */
    void saveUserTeam(UserTeamDto userTeamDto);


}
