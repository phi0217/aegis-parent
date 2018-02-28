package com.vxianjin.aegis.authorize.domain;

import javax.persistence.*;

/**
 * Created by Phi on 2018/1/12.
 */
@Entity
@Table(name = "back_role_module")
public class BackRoleModule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "module_id")
    private Integer moduleId;

    @Column(name = "role_id")
    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
