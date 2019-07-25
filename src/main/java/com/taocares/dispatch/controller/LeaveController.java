package com.taocares.dispatch.controller;

import com.taocares.dispatch.dto.LeaveDto;
import com.taocares.dispatch.entity.AttendanceState;
import com.taocares.dispatch.entity.Leave;
import com.taocares.dispatch.service.LeaveService;
import com.taocares.dispatch.utils.Return;
import com.taocares.dispatch.vo.LeaveVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 请假记录Controller
 *
 * @author qinkai
 * @date 2018/10/29
 */
@Api(description = "请假记录Controller")
@RestController
@RequestMapping("dispatch")
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    /**
     * 查询请假记录
     *
     * @param id
     * @return com.taocares.dispatch.dto.LeaveDto
     */
    @ApiOperation(value = "查询请假记录")
    @GetMapping("/leave/{id}")
    public LeaveDto getLeave(@PathVariable("id") Integer id) {
        return leaveService.getLeaveById(id);
    }

    /**
     * 根据id查询请假记录和审批记录
     *
     * @param id
     * @return com.taocares.dispatch.vo.LeaveVo
     */
    @ApiOperation(value = "根据id查询请假记录和审批记录")
    @GetMapping("/leaves")
    public LeaveVo listLeave(Integer id) {
        return leaveService.listLeave(id);
    }

    /**
     * 删除请假记录
     *
     * @param id
     * @return java.lang.String
     */
    @ApiOperation(value = "删除请假记录")
    @DeleteMapping("/leave/{id}")
    public String deleteLeave(@PathVariable("id") Integer id) {
        leaveService.removeLeave(id);
        return "success";
    }

    /**
     * 保存请假记录
     *
     * @param leaveDto
     * @param result
     * @return java.lang.String
     */
    @ApiOperation(value = "保存请假记录")
    @PostMapping("/leave")
    public String saveLeave(@Validated LeaveDto leaveDto, BindingResult result) {
        if (result.hasErrors()) {
            return result.getFieldError().getDefaultMessage();
        }
        leaveService.saveOrUpdateLeave(leaveDto);
        return "success";
    }

    /**
     * 更新请假记录
     *
     * @param leaveDto
     * @return java.lang.String
     */
    @ApiOperation(value = "更新请假记录")
    @PatchMapping("/leave")
    public String updateLeave(LeaveDto leaveDto) {
        if (leaveService.updateLeave(leaveDto)) {
            return "success";
        } else {
            return "fail";
        }
    }
}
