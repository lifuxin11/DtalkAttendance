package com.taocares.dispatch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 用户班组
 *
 * @author qinkai
 * @date 2018/09/30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTeamDto {
    private int id;
    @NotNull(message="parameter error")
    private Integer userId;
    @NotNull(message="parameter error")
    private Integer teamId;

}
