package com.taocares.dispatch.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.taocares.dispatch.entity.AttendanceState;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 班制
 *
 * @author qinkai
 * @date 2018/09/30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "班制")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class InstitutionDto {
    @ApiModelProperty(value = "主键id")
    private Integer id;
    @NotBlank(message="parameter error")
    @ApiModelProperty(value = "名称")
    private String name;
    @NotBlank(message="parameter error")
    @ApiModelProperty(value = "工作天数")
    private String workday;
    @NotBlank(message="parameter error")
    @ApiModelProperty(value = "休息天数")
    private String playday;
    @ApiModelProperty(value = "考勤状态")
    private List<AttendanceState> attendanceStates;

}
