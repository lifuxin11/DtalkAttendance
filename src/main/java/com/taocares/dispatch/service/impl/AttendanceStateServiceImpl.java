package com.taocares.dispatch.service.impl;

import com.taocares.commons.beans.BeanUtils;
import com.taocares.dispatch.constant.ParamKeyEnum;
import com.taocares.dispatch.dto.AttendanceStateDto;
import com.taocares.dispatch.entity.AttendanceState;
import com.taocares.dispatch.repository.AttendanceStateRepository;
import com.taocares.dispatch.service.AttendanceStateService;
import com.taocares.dispatch.utils.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 考勤状态ServiceImpl
 *
 * @author qinkai
 * @date 2018/10/10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AttendanceStateServiceImpl implements AttendanceStateService {
    @Autowired
    private AttendanceStateRepository attendanceStateRepository;

    @Override
    public void saveOrUpdateAttendanceState(AttendanceStateDto attendanceStateDto) {
        AttendanceState attendanceState = BeanUtils.copyProperties(attendanceStateDto, AttendanceState.class);
        if (attendanceState.getId() == null) {
            attendanceState.setCreateTime(new Date());
            attendanceState.setUpdateTime(new Date());
            attendanceStateRepository.save(attendanceState);
        } else {
            Optional<AttendanceState> optional = attendanceStateRepository.findById(attendanceState.getId());
            if (optional.isPresent()) {
                attendanceState.setUpdateTime(new Date());
                attendanceState.setCreateTime(optional.get().getCreateTime());
                attendanceStateRepository.save(attendanceState);
            }
        }

    }

    @Override
    @Transactional(readOnly = true)
    public Page<AttendanceStateDto> listAttendanceState(Map<String, String> params) {
        int page, limit;
        if (params.get(ParamKeyEnum.PARAM_PAGE.getCode()) == null || params.get(ParamKeyEnum.PARAM_LIMIT.getCode()) == null) {
            page = 1;
            limit = 10;
        } else {
            page = Integer.parseInt(params.get(ParamKeyEnum.PARAM_PAGE.getCode()));
            limit = Integer.parseInt(params.get(ParamKeyEnum.PARAM_LIMIT.getCode()));
        }
        Pageable pageable = new PageRequest(page - 1, limit, Sort.Direction.DESC, "updateTime");
        Page<AttendanceState> attendanceStates = attendanceStateRepository.findAll(pageable);
        return (Page<AttendanceStateDto>) BeanUtils.copyProperties(attendanceStates, AttendanceStateDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public AttendanceStateDto getAttendanceStateById(Integer id) {
        Optional<AttendanceState> optional = attendanceStateRepository.findById(id);
        if(optional.isPresent()){
            return BeanUtils.copyProperties(optional.get(),AttendanceStateDto.class);
        }else {
            return null;
        }
    }

    @Override
    public void removeAttendanceState(Integer id) {
        attendanceStateRepository.deleteById(id);
    }
}
