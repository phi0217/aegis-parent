package com.vxianjin.aegis.authorize.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.*;

/**
 * 后台用户对象
 * Created by Phi on 2018/1/11.
 */
@Entity
@Table(name = "back_user")
public class BackUser implements UserDetails, Serializable {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return telephone;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "password")
    private String password;

    @Column(name = "back_department_id")
    private Integer backDepartmentId;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;

    @NotNull(message = "手机号码不能为空")
    @Pattern(regexp = "^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57]|199)[0-9]{8}$", message = "请输入正确的手机号码")
    @Column(name = "telephone")
    private String telephone;

    @Column(name = "create_date", updatable = false)
    private Date createDate;

    @Column(name = "update_date", updatable = false)
    private Date updateDate;

    @Column(name = "remark")
    private String remark;

    @Column(name = "add_ip")
    private String addIp;

    @Column(name = "status")
    private Integer status;

    /**
     * 用户有权访问的所有url，不持久化到数据库
     */
    @Transient
    private Set<String> urls = new HashSet<>();

    /**
     * 用户所有角色，不持久化到数据库
     */
    @Transient
    private Set<BackRole> backRoles = new HashSet<>();

    /**
     * 用户性别
     */
    public static final HashMap<Integer, String> ALL_SEX = new HashMap<Integer, String>();
    /**
     * 男
     */
    public static final Integer SEX_MALE = 1;
    /**
     * 女
     */
    public static final Integer SEX_FEMALE = 2;

    static {
        ALL_SEX.put(SEX_MALE, "男");
        ALL_SEX.put(SEX_FEMALE, "女");
    }

    /**
     * 用户状态
     */
    public static final HashMap<Integer, String> ALL_STATUS = new HashMap<Integer, String>();
    /**
     * 启用
     */
    public static final Integer STATUS_USE = 1;
    /**
     * 删除
     */
    public static final Integer STATUS_DELETE = 2;

    static {
        ALL_STATUS.put(STATUS_USE, "启用");
        ALL_STATUS.put(STATUS_DELETE, "删除");
    }

    public Integer getBackDepartmentId() {
        return backDepartmentId;
    }

    public void setBackDepartmentId(Integer backDepartmentId) {
        this.backDepartmentId = backDepartmentId;
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAddIp() {
        return addIp;
    }

    public void setAddIp(String addIp) {
        this.addIp = addIp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<String> getUrls() {
        return urls;
    }

    public void setUrls(Set<String> urls) {
        this.urls = urls;
    }

    public Set<BackRole> getBackRoles() {
        return backRoles;
    }

    public void setBackRoles(Set<BackRole> backRoles) {
        this.backRoles = backRoles;
    }
}
