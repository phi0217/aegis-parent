package com.vxianjin.aegis.authorize.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Phi on 2018/1/11.
 */
@Entity
@Table(name = "back_user_role")
public class BackUserRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "user_id")
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
