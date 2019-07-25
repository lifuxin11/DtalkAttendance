package com.taocares.dispatch.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 用户
 *
 * @author qinkai
 * @date 2018/10/16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户")
public class AuthUserDto {
    @ApiModelProperty(value = "主键id")
    private Integer id;
    private Integer version;
    private Boolean deleted;
    private String jobnumber;
    @ApiModelProperty(value = "姓名")
    private String name;
    private Boolean onduty;
    private String password;
    private Boolean sex;
    private String tel;
}
