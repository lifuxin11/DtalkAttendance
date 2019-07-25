package com.taocares.dispatch.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import java.util.Date;


/**
 * 考勤
 *
 * @author qinkai
 * @date 2018/09/30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "考勤")
public class AttendanceDto {
    @ApiModelProperty(value = "主键id")
    private Integer id;
    @ApiModelProperty(value = "考勤状态")
    private AttendanceState attendanceState;
    @ApiModelProperty(value = "用户id")
    private Integer userId;
    @ApiModelProperty(value = "考勤状态id")
    private Integer stateId;
    @ApiModelProperty(value = "日期")
    @Mapping(field = "date", converter = DateToLongConverter.class, inverseConverter = LongToDateConverter.class)
    private Long date;
    @ApiModelProperty(value = "签到时间")
    @Mapping(field = "signTime", converter = DateToLongConverter.class, inverseConverter = LongToDateConverter.class)
    private Long signTime;
    @ApiModelProperty(value = "加班时间")
    private String overtime;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "用户")
    private AuthUser authUser;

}
