package com.taocares.dispatch.controller;

import com.taocares.dispatch.dto.AttendanceDto;
import com.taocares.dispatch.entity.Attendance;
import com.taocares.dispatch.entity.Attendance;
import com.taocares.dispatch.service.AttendanceService;
import com.taocares.dispatch.utils.Return;
import com.taocares.dispatch.vo.AutomaticSchedulVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * 排班Controller
 *
 * @author qinkai
 * @date 2018/10/22
 */
@Api(description = "排班Controller")
@RestController
@RequestMapping("dispatch")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;


    /**
     * 自动排班
     *
     * @param automaticSchedul
     * @param result
     * @return java.lang.String
     */
    @ApiOperation(value = "自动排班")
    @PostMapping("/automaticSchedul")
    public String saveAutomaticSchedul(@Validated AutomaticSchedulVo automaticSchedul, BindingResult result) {
        if (result.hasErrors()) {
            return result.getFieldError().getDefaultMessage();
        }
        attendanceService.saveAttendance(automaticSchedul);
        return "success";
    }

    /**
     * 查询考勤
     *
     * @param id
     * @return com.taocares.dispatch.dto.AttendanceDto
     */
    @ApiOperation(value = "查询考勤")
    @GetMapping("/attendance/{id}")
    public AttendanceDto getAttendance(@PathVariable("id") Integer id) {
        return attendanceService.getAttendanceById(id);
    }


    /**
     * 条件查询考勤
     *
     * @param params
     * @return java.util.List<com.taocares.dispatch.dto.AttendanceDto>
     */
    @ApiOperation(value = "条件查询考勤")
    @GetMapping("/attendances")
    public List<AttendanceDto> listAttendance(@RequestParam Map<String, String> params) throws ParseException {
        return attendanceService.listAttendance(params);
    }


    /**
     * 删除考勤
     *
     * @param id
     * @return java.lang.String
     */
    @ApiOperation(value = "删除考勤")
    @DeleteMapping("/attendance/{id}")
    public String deleteAttendance(@PathVariable("id") Integer id) {
        attendanceService.removeAttendance(id);
        return "success";
    }


    /**
     * 添加考勤
     *
     * @param attendanceDto
     * @param result
     * @return java.lang.String
     */
    @ApiOperation(value = "添加考勤")
    @PostMapping("/attendance")
    public String saveAttendance(@Validated({}) AttendanceDto attendanceDto, BindingResult result) {
        if (result.hasErrors()) {
            return result.getFieldError().getDefaultMessage();
        }
        attendanceService.saveOrUpdateAttendance(attendanceDto);
        return "success";
    }


    /**
     * 考勤签到
     *
     * @param attendanceDto
     * @return java.lang.String
     */
    @ApiOperation(value = "考勤签到")
    @PostMapping("/signIn")
    public String signIn(AttendanceDto attendanceDto) {
        if (attendanceDto.getId() != null) {
            AttendanceDto signInAttendance = attendanceService.getAttendanceById(attendanceDto.getId());
            signInAttendance.setDate(attendanceDto.getDate());
            attendanceService.saveOrUpdateAttendance(signInAttendance);
            return "success";
        } else {
            return "fail";
        }
    }
}
