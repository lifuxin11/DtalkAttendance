package com.taocares.dispatch.service.impl;

import com.taocares.commons.beans.BeanUtils;
import com.taocares.dispatch.constant.DispatchEnum;
import com.taocares.dispatch.dto.AttendanceStateDto;
import com.taocares.dispatch.dto.LeaveDto;
import com.taocares.dispatch.entity.Attendance;
import com.taocares.dispatch.entity.AttendanceState;
import com.taocares.dispatch.entity.Leave;
import com.taocares.dispatch.repository.AttendanceRepository;
import com.taocares.dispatch.repository.AttendanceStateRepository;
import com.taocares.dispatch.repository.LeaveRepository;
import com.taocares.dispatch.service.LeaveService;
import com.taocares.dispatch.utils.Return;
import com.taocares.dispatch.vo.LeaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 请假记录ServiceImpl
 *
 * @author qinkai
 * @date 2018/10/29
 */
@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private AttendanceStateRepository attendanceStateRepository;

    @Autowired
    private LeaveRepository leaveRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public List<AttendanceStateDto> listAttendanceState() {
        AttendanceState attendanceState = new AttendanceState();
        attendanceState.setName(DispatchEnum.DISPATCH_LEAVE_ATTENDANCESTATE.getCode());
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.endsWith());
        Example<AttendanceState> example = Example.of(attendanceState, matcher);
        List<AttendanceState> attendanceStateList = attendanceStateRepository.findAll(example);
        return BeanUtils.copyProperties(attendanceStateList, AttendanceStateDto.class);
    }

    @Override
    public void saveOrUpdateLeave(LeaveDto leaveDto) {
        Leave leave = BeanUtils.copyProperties(leaveDto,Leave.class);
        leave.setState(0);
        leave.setCreateTime(new Date());
        leaveRepository.save(leave);
    }


    @Override
    public LeaveDto getLeaveById(Integer id) {
         Optional<Leave> optional = leaveRepository.findById(id);
         if(optional.isPresent()){
             return BeanUtils.copyProperties(optional.get(),LeaveDto.class);
         }else {
             return null;
         }
    }

    @Override
    public void removeLeave(Integer id) {
        leaveRepository.deleteById(id);
    }

    @Override
    public LeaveVo listLeave(Integer id) {
        LeaveVo leaveVo = new LeaveVo();
        Leave leave = new Leave();
        leave.setLeaveUserId(id);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("leaveUserId", ExampleMatcher.GenericPropertyMatchers.exact());
        Example<Leave> example = Example.of(leave, matcher);
        List<Leave> applyLeaveList = leaveRepository.findAll(example);
        leaveVo.setApplyLeaveList(applyLeaveList);
        leave.setApproveUserId(id);
        matcher = ExampleMatcher.matching()
                .withMatcher("approveUserId", ExampleMatcher.GenericPropertyMatchers.exact())
                .withIgnorePaths("leaveUserId");
        example = Example.of(leave, matcher);
        List<Leave> reviewLeaveList = leaveRepository.findAll(example);
        leaveVo.setReviewLeaveList(reviewLeaveList);
        return leaveVo;
    }

    @Override
    public boolean updateLeave(LeaveDto leaveDto) {
        Leave leave = BeanUtils.copyProperties(leaveDto,Leave.class);
        if (leave != null) {
            if (leave.getId() != null) {
                Integer state = 0;
                if ((leave.getState() != null) &&
                        (leave.getState() == 0 || leave.getState() == 1 || leave.getState() == 2)) {
                    Leave l = leaveRepository.getOne(leave.getId());
                    if (l != null) {
                        l.setState(leave.getState());
                        leaveRepository.save(l);
                        if (l.getState() == 1) {
                            Calendar calendar = Calendar.getInstance();
                            Date startDate = l.getStartTime();
                            Date endDate = l.getEndTime();
                            calendar.setTime(startDate);
                            for (; calendar.getTime().getTime() <= endDate.getTime(); calendar.add(Calendar.DATE, 1)) {
                                Integer leaveUserId = l.getLeaveUserId();
                                Integer stateId = l.getStateId();
                                Attendance attendance = attendanceRepository.findByUserIdAndDate(leaveUserId, calendar.getTime());
                                if (attendance != null) {
                                    attendance.setStateId(stateId);
                                    attendanceRepository.save(attendance);
                                } else {
                                    attendance = new Attendance();
                                    attendance.setStateId(stateId);
                                    attendance.setDate(calendar.getTime());
                                    attendance.setUserId(leaveUserId);
                                    attendanceRepository.save(attendance);
                                }
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
