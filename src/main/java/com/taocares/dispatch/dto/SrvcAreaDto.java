package com.taocares.dispatch.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 服务区域
 *
 * @author qinkai
 * @date 2018/10/18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "服务区域")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class SrvcAreaDto {
    @ApiModelProperty(value = "主键id")
    private Integer id;
    private Integer areaId;
    @ApiModelProperty(value = "名称")
    private String name;
    private String type;
    private String tel;
    private String remark;
    private String operator;
    private String inchargePerson;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;

}
