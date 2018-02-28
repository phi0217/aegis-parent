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

    @Column(name = "super_id")
    private Integer  superId ;

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

    public Integer getSuperId() {
        return superId;
    }

    public void setSuperId(Integer superId) {
        this.superId = superId;
    }
}