package com.taocares.dispatch.service.impl;

import com.taocares.dispatch.constant.ParamKeyEnum;
import com.taocares.dispatch.dto.AttendanceDto;
import com.taocares.dispatch.entity.*;
import com.taocares.dispatch.repository.AttendanceRepository;
import com.taocares.dispatch.repository.InstitutionStateRepository;
import com.taocares.dispatch.repository.SrvcAreaRepository;
import com.taocares.dispatch.repository.TeamRepository;
import com.taocares.dispatch.service.AttendanceService;
import com.taocares.dispatch.vo.AutomaticSchedulVo;
import org.springframework.beans.factory.annotation.Autowired;
import com.taocares.commons.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 考勤ServiceImpl
 *
 * @author qinkai
 * @date 2018/10/22
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private SrvcAreaRepository srvcAreaRepository;
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    InstitutionStateRepository institutionStateRepository;


    @Override
    public void saveAttendance(AutomaticSchedulVo automaticSchedul) {
        if (automaticSchedul.getAreaId() == null) {
            List<SrvcArea> srvcAreas = srvcAreaRepository.findAll();
            for (SrvcArea srvcArea : srvcAreas) {
                automaticSchedul(srvcArea, automaticSchedul);
            }
        } else {
            SrvcArea srvcArea = srvcAreaRepository.getOne(automaticSchedul.getAreaId());
            automaticSchedul(srvcArea, automaticSchedul);
        }

    }

    @Override
    public void saveOrUpdateAttendance(AttendanceDto attendanceDto) {
        attendanceRepository.save(BeanUtils.copyProperties(attendanceDto, Attendance.class));
    }

    @Override
    public List<AttendanceDto> listAttendance(Map<String, String> params) throws ParseException {
        Date startDate = null;
        Date endDate = null;
        Integer id = null;
        String name = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        if (params.containsKey(ParamKeyEnum.PARAM_ID.getCode())) {
            id = Integer.valueOf(params.get(ParamKeyEnum.PARAM_ID.getCode()));
        }
        if (params.containsKey(ParamKeyEnum.PARAM_NAME.getCode())) {
            name = params.get(ParamKeyEnum.PARAM_NAME.getCode());
        }
        if (params.containsKey(ParamKeyEnum.PARAM_START_DATE.getCode())) {
            startDate = formatter.parse(params.get(ParamKeyEnum.PARAM_START_DATE.getCode()));
        }
        if (params.containsKey(ParamKeyEnum.PARAM_END_DATE.getCode())) {
            endDate = formatter.parse(params.get(ParamKeyEnum.PARAM_END_DATE.getCode()));
        }
        List<Attendance> attendanceList = attendanceRepository.findAttendance(id, name, startDate, endDate);
        return BeanUtils.copyProperties(attendanceList, AttendanceDto.class);
    }

    @Override
    public AttendanceDto getAttendanceById(Integer id) {
        Optional<Attendance> optional = attendanceRepository.findById(id);
        if (optional.isPresent()) {
            return BeanUtils.copyProperties(optional.get(), AttendanceDto.class);
        } else {
            return null;
        }

    }

    @Override
    public void removeAttendance(Integer id) {
        attendanceRepository.deleteById(id);
    }

    private void automaticSchedul(SrvcArea srvcArea, AutomaticSchedulVo automaticSchedul) {
        Date startDate = automaticSchedul.getStartDate();
        Date endDate = automaticSchedul.getEndDate();
        Calendar calendar = Calendar.getInstance();
        Calendar start = Calendar.getInstance();
        calendar.setTime(startDate);
        List<Team> teamList = teamRepository.findAll(srvcArea.getId(), new Sort(Sort.Direction.ASC, "order"));
        int j = 0;
        int k = 0;
        int playDay = 0;
        Date startTime = null;
        for (int i = 0; calendar.getTime().getTime() <= endDate.getTime(); calendar.add(Calendar.DATE, 1)) {
            if (j != 0 || k != 0) {
                if (j >= k) {
                    if (i == 0) {
                        start.setTime(calendar.getTime());
                        start.add(Calendar.DATE, playDay - 1);
                        startTime = start.getTime();
                    }
                    i++;
                    j = 0;
                    k = 0;
                }
            }
            if (i == teamList.size()) {
                i = 0;
            }
            Team team = teamList.get(i);
            if (k == 0) {
                k = Integer.parseInt(team.getInstitution().getWorkday());
                playDay = Integer.parseInt(team.getInstitution().getPlayday());
            }
            if (startTime == null || calendar.getTime().after(startTime) || i != 0) {
                List<InstitutionState> institutionStates = institutionStateRepository.findByInstitutionId(
                        team.getInstitutionId(), new Sort(Sort.Direction.ASC, "order"));
                Integer stateId = institutionStates.get(0).getStateId();
                List<AuthUser> authUsers = team.getAuthUsers();
                for (AuthUser authUser : authUsers) {
                    Attendance attendance = new Attendance();
                    attendance.setDate(calendar.getTime());
                    attendance.setStateId(stateId);
                    attendance.setUserId(authUser.getId());
                    attendanceRepository.save(attendance);
                }
                j++;
            }

        }
    }
}
