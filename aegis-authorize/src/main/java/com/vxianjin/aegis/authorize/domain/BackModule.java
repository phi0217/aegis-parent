package com.vxianjin.aegis.authorize.domain;


import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by Phi on 2018/1/12.
 */
@Entity
@Table(name = "back_module")
public class BackModule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;//菜单名称

    @Column(name = "url")
    private String url;//菜单路径

    /**
     * 资源类型
     */
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private BackModuleType type;

    @Column(name = "style")
    private String style;//菜单打开方式及样式

    @Column(name = "describe")
    private String describe;//菜单描述

    @Column(name = "sequence")
    private Integer sequence;//排序

    @Column(name = "view")
    private Integer view;//是否显示，1为显示,0为隐藏

    @Column(name = "parent_id")
    private Integer parentId;//父菜单ID

    @Transient
    private Integer selected = 0;//是否选中 1是 0否

    @Transient
    private ArrayList<BackModule> childModules;//子节点

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSelected() {
        return selected;
    }

    public void setSelected(Integer selected) {
        this.selected = selected;
    }

    public ArrayList<BackModule> getChildModules() {
        return childModules;
    }

    public void setChildModules(ArrayList<BackModule> childModules) {

        this.childModules = childModules;
    }

    public BackModuleType getType() {
        return type;
    }

    public void setType(BackModuleType type) {
        this.type = type;
    }
}
