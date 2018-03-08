package com.vxianjin.aegis.authorize.service.impl;

import com.vxianjin.aegis.authorize.domain.*;
import com.vxianjin.aegis.authorize.repository.*;
import com.vxianjin.aegis.authorize.service.BackModuleService;
import com.vxianjin.aegis.authorize.service.BackUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xiefei
 * @date 2018/03/08
 */
@Service
public class BackUserServiceImpl implements BackUserService{
    @Autowired
    private BackModuleRepository backModuleRepository;
    @Autowired
    private BackUserRepository backUserRepository;
    @Autowired
    private BackRoleRepository backRoleRepository;
    @Autowired
    private BackUserRoleRepository backUserRoleRepository;
    @Autowired
    private BackRoleModuleRepository backRoleModuleRepository;
    @Override
    public BackUser getBackUser(String telephone) {
        BackUser backUser = backUserRepository.findByTelephone(telephone);
        /**
         * 根据用户获取用户角色关联角色
         */
        List<BackUserRole> backUserRoles = backUserRoleRepository.findAllByUserId(backUser.getId());
        /**
         * 用户角色关联获取角色
         */
        Set<Integer> idSet = new HashSet<>();
        for (BackUserRole backUserRole : backUserRoles) {
            idSet.add(backUserRole.getRoleId());
        }
        List<BackRole> backRoles = backRoleRepository.findAllByIdIn(idSet);

        /**
         * 角色获取角色资源关联
         */
        Set<Integer> roleModuleIdSet = new HashSet<>();
        for (BackRole backRole : backRoles) {
            roleModuleIdSet.add(backRole.getId());
        }
        List<BackRoleModule> backRoleModules = backRoleModuleRepository.findAllByRoleIdIn(roleModuleIdSet);
        /**
         * 角色资源关联获取资源
         */
        Set<Integer> moduleIdSet = new HashSet<>();
        for (BackRoleModule backRoleModule : backRoleModules) {
            moduleIdSet.add(backRoleModule.getModuleId());
        }
        List<BackModule> backModules = backModuleRepository.findAllByIdIn(moduleIdSet);
        /**
         * 获取资源url集合
         */
        Set<String> urls = new HashSet<>();
        for (BackModule backModule : backModules) {
            if (backModule.getUrl()!=null){
                urls.add(backModule.getUrl());
            }
        }
        backUser.setUrls(urls);
        Set<BackRole> backRoleSet = new HashSet<>();
        backRoleSet.addAll(backRoles);
        backUser.setBackRoles(backRoleSet);
        return backUser;
    }
}
