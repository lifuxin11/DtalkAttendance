package com.taocares.dispatch.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;


/**
 * 考勤状态
 *
 * @author qinkai
 * @date 2018/09/30
 */
@Entity
@Table(name = "tb_dispatch_attendance_state", schema = "dbo", catalog = "viptest")
public class AttendanceState {
    private Integer id;
    @NotBlank(message="parameter error")
    private String name;
    @NotBlank(message="parameter error")
    private String shortName;
    private String color;
    private Date createTime;
    private Date updateTime;

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    @Column(name = "short_name")
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "AttendanceState{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", color='" + color + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
