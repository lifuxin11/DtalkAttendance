package com.taocares.dispatch.service;

import com.taocares.dispatch.dto.AttendanceStateDto;
import com.taocares.dispatch.dto.LeaveDto;
import com.taocares.dispatch.entity.AttendanceState;
import com.taocares.dispatch.entity.Leave;
import com.taocares.dispatch.utils.Return;
import com.taocares.dispatch.vo.LeaveVo;

import java.util.List;
import java.util.Map;

/**
 * 请假记录Service
 *
 * @author qinkai
 * @date 2018/10/29
 */
public interface LeaveService {

    /**
     * 查询考勤状态
     *
     * @param
     * @return java.util.List<com.taocares.dispatch.dto.AttendanceStateDto>
     */
    List<AttendanceStateDto> listAttendanceState();


    /**
     * 保存或更新请假记录
     *
     * @param leaveDto
     * @return void
     */
    void saveOrUpdateLeave(LeaveDto leaveDto);

    /**
     * 根据id查询请假记录
     *
     * @param id
     * @return com.taocares.dispatch.dto.LeaveDto
     */
    LeaveDto getLeaveById(Integer id);

    /**
     * 删除请假记录
     *
     * @param id
     * @return void
     */
    void removeLeave(Integer id);

    /**
     * 根据用户id查询请假记录
     *
     * @param id
     * @return com.taocares.dispatch.vo.LeaveVo
     */
    LeaveVo listLeave(Integer id);


    /**
     * 更新请假记录
     *
     * @param leaveDto
     * @return boolean
     */
    boolean updateLeave(LeaveDto leaveDto);

}
