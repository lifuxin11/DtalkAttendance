package com.taocares.dispatch.service;

import com.taocares.dispatch.dto.AttendanceStateDto;
import com.taocares.dispatch.entity.Attendance;
import com.taocares.dispatch.entity.AttendanceState;
import com.taocares.dispatch.utils.Return;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * 考勤状态Service
 *
 * @author qinkai
 * @date 2018/09/30
 */
public interface AttendanceStateService {

    /**
     * 保存或更新考勤状态
     *
     * @param attendanceStateDto
     * @return void
     */
    void saveOrUpdateAttendanceState(AttendanceStateDto attendanceStateDto);

    /**
     * 根据条件查询考勤状态
     *
     * @param params
     * @return org.springframework.data.domain.Page<com.taocares.dispatch.dto.AttendanceStateDto>
     */
    Page<AttendanceStateDto> listAttendanceState(Map<String, String> params);

    /**
     * 根据id查询考勤状态
     *
     * @param id
     * @return com.taocares.dispatch.dto.AttendanceStateDto
     */
    AttendanceStateDto getAttendanceStateById(Integer id);

    /**
     * 删除考勤状态
     *
     * @param id
     * @return void
     */
    void removeAttendanceState(Integer id);


}
