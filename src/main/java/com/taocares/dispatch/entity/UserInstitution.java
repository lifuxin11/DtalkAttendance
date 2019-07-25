package com.taocares.dispatch.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 用户班制
 *
 * @author qinkai
 * @date 2018/10/17
 */
@Entity
@Table(name = "tb_user_institution", schema = "dbo", catalog = "viptest")
public class UserInstitution {
    private Integer id;
    @NotNull(message="parameter error")
    private Integer userId;
    @NotNull(message="parameter error")
    private Integer institutionId;


    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Integer institutionId) {
        this.institutionId = institutionId;
    }
}
