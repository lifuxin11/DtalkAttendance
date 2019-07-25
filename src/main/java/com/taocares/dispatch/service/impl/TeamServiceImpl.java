package com.taocares.dispatch.service.impl;


import com.taocares.commons.beans.BeanUtils;
import com.taocares.dispatch.constant.ParamKeyEnum;
import com.taocares.dispatch.dto.TeamDto;
import com.taocares.dispatch.dto.UserTeamDto;
import com.taocares.dispatch.entity.Team;
import com.taocares.dispatch.entity.UserTeam;
import com.taocares.dispatch.repository.TeamRepository;
import com.taocares.dispatch.repository.UserTeamRepository;
import com.taocares.dispatch.service.TeamService;
import com.taocares.dispatch.utils.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

/**
 * 班组ServiceImpl
 *
 * @author qinkai
 * @date 2018/10/10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserTeamRepository userTeamRepository;


    @Override
    public void saveOrUpdateTeam(TeamDto teamDto) {
        teamRepository.save(BeanUtils.copyProperties(teamDto, Team.class));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TeamDto> listTeam(Map<String, String> params) {
        int page, limit;
        if (params.containsKey(ParamKeyEnum.PARAM_PAGE.getCode()) || params.containsKey(ParamKeyEnum.PARAM_LIMIT.getCode())) {
            page = Integer.parseInt(params.get(ParamKeyEnum.PARAM_PAGE.getCode()));
            limit = Integer.parseInt(params.get(ParamKeyEnum.PARAM_LIMIT.getCode()));
        } else {
            page = 1;
            limit = 10;
        }
        Integer id = null;
        if (params.containsKey(ParamKeyEnum.PARAM_ID.getCode())) {
            id = Integer.valueOf(params.get(ParamKeyEnum.PARAM_ID.getCode()));
        }
        Pageable pageable = new PageRequest(page - 1, limit, Sort.Direction.DESC, "id");

        Page<Team> teamPage = teamRepository.findAll(id, pageable);
        return (Page<TeamDto>) BeanUtils.copyProperties(teamPage,TeamDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public TeamDto getTeamById(Integer id) {
        Optional<Team> optional = teamRepository.findById(id);
        if(optional.isPresent()){
            return BeanUtils.copyProperties(optional.get(),TeamDto.class);
        }else {
            return null;
        }
    }

    @Override
    public void removeTeam(Integer id) {
        teamRepository.deleteById(id);
    }

    @Override
    public void removeUserTeam(Integer id) {
        userTeamRepository.deleteById(id);
    }

    @Override
    public void saveUserTeam(UserTeamDto userTeamDto) {
        userTeamRepository.save(BeanUtils.copyProperties(userTeamDto, UserTeam.class));
    }
}
