package com.taocares.dispatch.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 班制
 *
 * @author qinkai
 * @date 2018/09/30
 */
@Entity
@Table(name = "tb_dispatch_institution", schema = "dbo", catalog = "viptest")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Institution {
    private Integer id;
    @NotBlank(message="parameter error")
    private String name;
    @NotBlank(message="parameter error")
    private String workday;
    @NotBlank(message="parameter error")
    private String playday;

    private List<AttendanceState> attendanceStates;

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
    @Column(name = "workday")
    public String getWorkday() {
        return workday;
    }

    public void setWorkday(String workday) {
        this.workday = workday;
    }

    @Basic
    @Column(name = "playday")
    public String getPlayday() {
        return playday;
    }

    public void setPlayday(String playday) {
        this.playday = playday;
    }

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "tb_institution_state", joinColumns = @JoinColumn(name = "institution_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "state_id", referencedColumnName = "id"))
    @OrderBy("ordernum ASC")
    public List<AttendanceState> getAttendanceStates() {
        return attendanceStates;
    }

    public void setAttendanceStates(List<AttendanceState> attendanceStates) {
        this.attendanceStates = attendanceStates;
    }


}
