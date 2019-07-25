package com.taocares.dispatch.dto;

import com.taocares.commons.beans.annotation.Mapping;
import com.taocares.dispatch.converter.DateToLongConverter;
import com.taocares.dispatch.converter.LongToDateConverter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


/**
 * 考勤状态
 *
 * @author qinkai
 * @date 2018/09/30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "考勤状态")
public class AttendanceStateDto {
    @ApiModelProperty(value = "主键id")
    private Integer id;
    @NotBlank(message="parameter error")
    @ApiModelProperty(value = "名称")
    private String name;
    @NotBlank(message="parameter error")
    @ApiModelProperty(value = "短名称")
    private String shortName;
    @ApiModelProperty(value = "颜色")
    private String color;
    @Mapping(field = "createTime", converter = DateToLongConverter.class, inverseConverter = LongToDateConverter.class)
    @ApiModelProperty(value = "创建时间")
    private Long createTime;
    @Mapping(field = "updateTime", converter = DateToLongConverter.class, inverseConverter = LongToDateConverter.class)
    @ApiModelProperty(value = "修改时间")
    private Long updateTime;

}
