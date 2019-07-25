package com.taocares.dispatch.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.taocares.commons.beans.annotation.Mapping;
import com.taocares.dispatch.converter.DateToLongConverter;
import com.taocares.dispatch.converter.LongToDateConverter;
import com.taocares.dispatch.entity.AttendanceState;
import com.taocares.dispatch.entity.AuthUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * 请假记录
 *
 * @author qinkai
 * @date 2018/10/29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "请假记录")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class LeaveDto {
    @ApiModelProperty(value = "主键id")
    private Integer id;
    @ApiModelProperty(value = "请假人id")
    private Integer leaveUserId;
    @NotNull(message="parameter error")
    @ApiModelProperty(value = "审批人id")
    private Integer approveUserId;
    @NotNull(message="parameter error")
    @ApiModelProperty(value = "考勤状态id")
    private Integer stateId;
    @NotNull(message="parameter error")
    @Mapping(field = "startTime", converter = DateToLongConverter.class, inverseConverter = LongToDateConverter.class)
    @ApiModelProperty(value = "开始时间")
    private Long startTime;
    @NotNull(message="parameter error")
    @Mapping(field = "endTime", converter = DateToLongConverter.class, inverseConverter = LongToDateConverter.class)
    @ApiModelProperty(value = "结束时间")
    private Long endTime;
    @ApiModelProperty(value = "请假事由")
    private String cause;
    @ApiModelProperty(value = "请假天数")
    private Integer day;
    @ApiModelProperty(value = "状态")
    private Integer state;
    @Mapping(field = "createTime", converter = DateToLongConverter.class, inverseConverter = LongToDateConverter.class)
    @ApiModelProperty(value = "创建时间")
    private Long createTime;
    @ApiModelProperty(value = "请假人")
    private AuthUser leaveUser;
    @ApiModelProperty(value = "审批人")
    private AuthUser approveUser;
    @ApiModelProperty(value = "考勤状态")
    private AttendanceState attendanceState;

}
