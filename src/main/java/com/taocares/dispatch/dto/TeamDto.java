package com.taocares.dispatch.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.taocares.dispatch.entity.AuthUser;
import com.taocares.dispatch.entity.Institution;
import com.taocares.dispatch.entity.SrvcArea;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 班组
 *
 * @author qinkai
 * @date 2018/09/30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "班组")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class TeamDto {
    @ApiModelProperty(value = "主键id")
    private Integer id;
    @ApiModelProperty(value = "服务区域")
    private SrvcArea srvcArea;
    @NotNull(message="parameter error")
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "备注")
    private String remark;
    @NotNull(message="parameter error")
    @ApiModelProperty(value = "服务区域id")
    private Integer areaId;
    @NotNull(message="parameter error")
    @ApiModelProperty(value = "班制id")
    private Integer institutionId;
    @ApiModelProperty(value = "顺序")
    private Integer order;
    @ApiModelProperty(value = "用户")
    private List<AuthUser> authUsers;
    @ApiModelProperty(value = "班制")
    private Institution institution;

}
