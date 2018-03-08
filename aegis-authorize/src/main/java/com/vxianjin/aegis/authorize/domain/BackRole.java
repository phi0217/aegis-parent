package com.vxianjin.aegis.authorize.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 角色对象
 * Created by Phi on 2018/1/11.
 */
@Entity
@Table(name = "back_role")
public class BackRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer  id ;

    @Column(name = "name")
    private String  name ;

    @Column(name = "summary")
    private String  summary ;

    @Column(name = "super_id")
    private Integer  superId ;

    @Column(name = "add_time")
    private Date  addTime ;

    @Column(name = "add_ip")
    private String  addIp ;

    @Transient
    private Integer selected = 0;//用户拥有角色1 未拥有0
    @Transient
    private List<BackModule> selectedModules = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getSuperId() {
        return superId;
    }

    public void setSuperId(Integer superId) {
        this.superId = superId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAddIp() {
        return addIp;
    }

    public void setAddIp(String addIp) {
        this.addIp = addIp;
    }

    public List<BackModule> getSelectedModules() {
        return selectedModules;
    }

    public void setSelectedModules(List<BackModule> selectedModules) {
        this.selectedModules = selectedModules;
    }

    public Integer getSelected() {
        return selected;
    }

    public void setSelected(Integer selected) {
        this.selected = selected;
    }
}