package com.taocares.dispatch.service;

import com.taocares.dispatch.dto.AttendanceDto;
import com.taocares.dispatch.entity.Attendance;
import com.taocares.dispatch.utils.Return;
import com.taocares.dispatch.vo.AutomaticSchedulVo;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * 考勤Service
 *
 * @author qinkai
 * @date 2018/09/30
 */
public interface AttendanceService {

    /**
     * 保存排班
     *
     * @param automaticSchedul
     * @return void
     */
    void saveAttendance(AutomaticSchedulVo automaticSchedul);


    /**
     * 保存或更新考勤
     *
     * @param attendanceDto
     * @return void
     */
    void saveOrUpdateAttendance(AttendanceDto attendanceDto);

    /**
     * 根据条件查询考勤
     *
     * @param params
     * @return java.util.List<com.taocares.dispatch.dto.AttendanceDto>
     */
    List<AttendanceDto> listAttendance(Map<String, String> params) throws ParseException;

    /**
     * 根据id查询考勤
     *
     * @param id
     * @return com.taocares.dispatch.dto.AttendanceDto
     */
    AttendanceDto getAttendanceById(Integer id);

    /**
     * 删除考勤
     *
     * @param id
     * @return void
     */
    void removeAttendance(Integer id);
}
