package com.taocares.dispatch.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 服务区域
 *
 * @author qinkai
 * @date 2018/10/18
 */
@Entity
@ApiModel(value = "服务区域")
@Table(name = "tb_srvc_area", schema = "dbo", catalog = "viptest")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class SrvcArea {
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

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "area_id")
    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "operator")
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Basic
    @Column(name = "incharge_person")
    public String getInchargePerson() {
        return inchargePerson;
    }

    public void setInchargePerson(String inchargePerson) {
        this.inchargePerson = inchargePerson;
    }

    @Basic
    @Column(name = "gmt_create")
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Basic
    @Column(name = "gmt_modified")
    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SrvcArea srvcArea = (SrvcArea) o;

        if (id != srvcArea.id) return false;
        if (areaId != null ? !areaId.equals(srvcArea.areaId) : srvcArea.areaId != null) return false;
        if (name != null ? !name.equals(srvcArea.name) : srvcArea.name != null) return false;
        if (type != null ? !type.equals(srvcArea.type) : srvcArea.type != null) return false;
        if (tel != null ? !tel.equals(srvcArea.tel) : srvcArea.tel != null) return false;
        if (remark != null ? !remark.equals(srvcArea.remark) : srvcArea.remark != null) return false;
        if (operator != null ? !operator.equals(srvcArea.operator) : srvcArea.operator != null) return false;
        if (inchargePerson != null ? !inchargePerson.equals(srvcArea.inchargePerson) : srvcArea.inchargePerson != null)
            return false;
        if (gmtCreate != null ? !gmtCreate.equals(srvcArea.gmtCreate) : srvcArea.gmtCreate != null) return false;
        if (gmtModified != null ? !gmtModified.equals(srvcArea.gmtModified) : srvcArea.gmtModified != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (areaId != null ? areaId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (inchargePerson != null ? inchargePerson.hashCode() : 0);
        result = 31 * result + (gmtCreate != null ? gmtCreate.hashCode() : 0);
        result = 31 * result + (gmtModified != null ? gmtModified.hashCode() : 0);
        return result;
    }
}
