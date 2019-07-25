package com.taocares.dispatch.controller;

import com.taocares.dispatch.dto.TeamDto;
import com.taocares.dispatch.dto.UserTeamDto;
import com.taocares.dispatch.entity.Team;
import com.taocares.dispatch.entity.UserTeam;
import com.taocares.dispatch.service.TeamService;
import com.taocares.dispatch.utils.Return;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 班组Controller
 *
 * @author qinkai
 * @date 2018/10/15
 */
@Api(description = "班组Controller")
@RestController
@RequestMapping("dispatch")
public class TeamController {
    @Autowired
    private TeamService teamService;

    /**
     * 查询班组
     *
     * @param id
     * @return com.taocares.dispatch.dto.TeamDto
     */
    @ApiOperation(value = "查询班组")
    @GetMapping("/team/{id}")
    public TeamDto getTeam(@PathVariable("id") Integer id) {
        return teamService.getTeamById(id);
    }

    /**
     * 条件查询班组
     *
     * @param params
     * @return org.springframework.data.domain.Page<com.taocares.dispatch.dto.TeamDto>
     */
    @ApiOperation(value = "条件查询班组")
    @GetMapping("/teams")
    public Page<TeamDto> listTeam(@RequestParam Map<String, String> params) {
        return teamService.listTeam(params);
    }

    /**
     * 删除班组
     *
     * @param id
     * @return java.lang.String
     */
    @ApiOperation(value = "删除班组")
    @DeleteMapping("/team/{id}")
    public String deleteTeam(@PathVariable("id") Integer id) {
        teamService.removeTeam(id);
        return "success";
    }

    /**
     * 保存班组
     *
     * @param teamDto
     * @param result
     * @return java.lang.String
     */
    @ApiOperation(value = "保存班组")
    @PostMapping("/team")
    public String saveTeam(@Validated TeamDto teamDto, BindingResult result) {
        if (result.hasErrors()) {
            return result.getFieldError().getDefaultMessage();
        }
        teamService.saveOrUpdateTeam(teamDto);
        return "success";
    }

    /**
     * 更新班组
     *
     * @param teamDto
     * @param result
     * @return java.lang.String
     */
    @ApiOperation(value = "更新班组")
    @PatchMapping("/team")
    public String updateTeam(@Validated TeamDto teamDto, BindingResult result) {
        if (result.hasErrors()) {
            return result.getFieldError().getDefaultMessage();
        }
        teamService.saveOrUpdateTeam(teamDto);
        return "success";
    }


    /**
     * 删除班组
     *
     * @param id
     * @return java.lang.String
     */
    @ApiOperation(value = "删除班组")
    @DeleteMapping("/userTeam/{id}")
    public String deleteUserTeam(@PathVariable("id") Integer id) {
        teamService.removeUserTeam(id);
        return "success";
    }

    /**
     * 添加用户班组
     *
     * @param userTeamDto
     * @param result
     * @return java.lang.String
     */
    @ApiOperation(value = "添加用户班组")
    @PostMapping("/userTeam")
    public String saveUserTeam(@Validated UserTeamDto userTeamDto, BindingResult result) {
        if (result.hasErrors()) {
            return result.getFieldError().getDefaultMessage();
        }
        teamService.saveUserTeam(userTeamDto);
        return "success";
    }


}
