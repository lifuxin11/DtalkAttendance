package com.taocares.dispatch.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 班组
 *
 * @author qinkai
 * @date 2018/09/30
 */
@Entity
@Table(name = "tb_dispatch_team", schema = "dbo", catalog = "dingtalk")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Team {
    private Integer id;
    private SrvcArea srvcArea;
    @NotNull(message="parameter error")
    private String name;
    private String remark;
    @NotNull(message="parameter error")
    private Integer areaId;
    @NotNull(message="parameter error")
    private Integer institutionId;
    private Integer order;
    private List<AuthUser> authUsers;
    private Institution institution;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "srvc_area_id", referencedColumnName = "id", insertable = false, updatable = false)
    public SrvcArea getSrvcArea() {
        return srvcArea;
    }

    public void setSrvcArea(SrvcArea srvcArea) {
        this.srvcArea = srvcArea;
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
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "tb_user_team", joinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    public List<AuthUser> getAuthUsers() {
        return authUsers;
    }

    public void setAuthUsers(List<AuthUser> authUsers) {
        this.authUsers = authUsers;
    }

    @Basic
    @Column(name = "srvc_area_id")
    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    @Basic
    @Column(name = "institution_id")
    public Integer getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Integer institutionId) {
        this.institutionId = institutionId;
    }

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "institution_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @Basic
    @Column(name = "team_order")
    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
