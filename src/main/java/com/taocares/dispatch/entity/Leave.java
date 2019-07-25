package com.taocares.dispatch.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * 请假记录
 *
 * @author qinkai
 * @date 2018/10/29
 */
@Entity
@Table(name = "tb_dispatch_leave", schema = "dbo", catalog = "dingtalk")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Leave {
    private Integer id;
    private Integer leaveUserId;
    @NotNull(message="parameter error")
    private Integer approveUserId;
    @NotNull(message="parameter error")
    private Integer stateId;
    @NotNull(message="parameter error")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date startTime;
    @NotNull(message="parameter error")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date endTime;
    private String cause;
    private Integer day;
    private Integer state;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date createTime;
    private AuthUser leaveUser;
    private AuthUser approveUser;
    private AttendanceState attendanceState;

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
    @Column(name = "leave_user_id")
    public Integer getLeaveUserId() {
        return leaveUserId;
    }

    public void setLeaveUserId(Integer leaveUserId) {
        this.leaveUserId = leaveUserId;
    }

    @Basic
    @Column(name = "approve_user_id")
    public Integer getApproveUserId() {
        return approveUserId;
    }

    public void setApproveUserId(Integer approveUserId) {
        this.approveUserId = approveUserId;
    }

    @Basic
    @Column(name = "state_id")
    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    @Basic
    @Column(name = "start_time")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "cause")
    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    @Basic
    @Column(name = "day")
    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    @Basic
    @Column(name = "state")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "leave_user_id", referencedColumnName = "id", insertable = false, updatable = false)
    public AuthUser getLeaveUser() {
        return leaveUser;
    }

    public void setLeaveUser(AuthUser leaveUser) {
        this.leaveUser = leaveUser;
    }

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "approve_user_id", referencedColumnName = "id", insertable = false, updatable = false)
    public AuthUser getApproveUser() {
        return approveUser;
    }

    public void setApproveUser(AuthUser approveUser) {
        this.approveUser = approveUser;
    }

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "state_id", referencedColumnName = "id", insertable = false, updatable = false)
    public AttendanceState getAttendanceState() {
        return attendanceState;
    }

    public void setAttendanceState(AttendanceState attendanceState) {
        this.attendanceState = attendanceState;
    }
}
