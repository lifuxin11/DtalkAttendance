package com.taocares.dispatch.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 班制状态
 *
 * @author qinkai
 * @date 2018/10/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class InstitutionStateDto {
    private Integer id;
    private Integer institutionId;
    private Integer stateId;
    private Integer order;
}
