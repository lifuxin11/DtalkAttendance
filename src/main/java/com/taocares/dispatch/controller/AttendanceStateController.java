package com.taocares.dispatch.controller;

import com.taocares.dispatch.dto.AttendanceStateDto;
import com.taocares.dispatch.entity.AttendanceState;
import com.taocares.dispatch.service.AttendanceStateService;
import com.taocares.dispatch.utils.Return;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 考勤状态Controller
 *
 * @author qinkai
 * @date 2018/10/15
 */
@Api(description = "考勤状态Controller")
@RestController
@RequestMapping("dispatch")
public class AttendanceStateController {
    @Autowired
    private AttendanceStateService attendanceStateService;

    /**
     * 查询考勤状态
     *
     * @param id
     * @return com.taocares.dispatch.dto.AttendanceStateDto
     */
    @ApiOperation(value = "查询考勤状态")
    @GetMapping("/attendanceState/{id}")
    public AttendanceStateDto getAttendanceState(@PathVariable("id") Integer id) {
        return attendanceStateService.getAttendanceStateById(id);
    }

    /**
     * 条件查询考勤状态
     *
     * @param params
     * @return org.springframework.data.domain.Page<com.taocares.dispatch.dto.AttendanceStateDto>
     */
    @ApiOperation(value = "条件查询考勤状态")
    @GetMapping("/attendanceStates")
    public Page<AttendanceStateDto> listAttendanceState(@RequestParam Map<String, String> params) {
        return attendanceStateService.listAttendanceState(params);
    }

    /**
     * 删除考勤状态
     *
     * @param id
     * @return java.lang.String
     */
    @ApiOperation(value = "删除考勤状态")
    @DeleteMapping("/attendanceState/{id}")
    public String deleteAttendanceState(@PathVariable("id") Integer id) {
        attendanceStateService.removeAttendanceState(id);
        return "success";
    }

    /**
     * 添加考勤状态
     *
     * @param attendanceStateDto
     * @param result
     * @return java.lang.String
     */
    @ApiOperation(value = "添加考勤状态")
    @PostMapping("/attendanceState")
    public String saveAttendanceState(@Validated AttendanceStateDto attendanceStateDto, BindingResult result) {
        if (result.hasErrors()) {
            return result.getFieldError().getDefaultMessage();
        }
        attendanceStateService.saveOrUpdateAttendanceState(attendanceStateDto);
        return "success";
    }

    /**
     * 更新考勤状态
     *
     * @param attendanceStateDto
     * @param result
     * @return java.lang.String
     */
    @ApiOperation(value = "更新考勤状态")
    @PatchMapping("/attendanceState")
    public String updateAttendanceState(@Validated AttendanceStateDto attendanceStateDto, BindingResult result) {
        if (result.hasErrors()) {
            return result.getFieldError().getDefaultMessage();
        }
        attendanceStateService.saveOrUpdateAttendanceState(attendanceStateDto);
        return "success";
    }

}
