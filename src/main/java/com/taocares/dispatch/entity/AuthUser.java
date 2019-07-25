package com.taocares.dispatch.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * 用户
 *
 * @author qinkai
 * @date 2018/10/16
 */
@Entity
@ApiModel(value = "用户")
@Table(name = "tb_auth_user", schema = "dbo", catalog = "dingtalk")
public class AuthUser {
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

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Transient
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Transient
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Basic
    @Column(name = "jobnumber")
    public String getJobnumber() {
        return jobnumber;
    }

    public void setJobnumber(String jobnumber) {
        this.jobnumber = jobnumber;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "onduty")
    public Boolean getOnduty() {
        return onduty;
    }

    public void setOnduty(Boolean onduty) {
        this.onduty = onduty;
    }

    @Transient
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "sex")
    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "id=" + id +
                ", version=" + version +
                ", deleted=" + deleted +
                ", jobnumber='" + jobnumber + '\'' +
                ", name='" + name + '\'' +
                ", onduty=" + onduty +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", tel='" + tel + '\'' +
                '}';
    }
}
