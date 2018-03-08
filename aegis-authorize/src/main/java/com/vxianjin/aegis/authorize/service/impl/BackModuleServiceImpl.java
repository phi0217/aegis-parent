/**
 * 
 */
package com.vxianjin.aegis.authorize.service.impl;

import com.vxianjin.aegis.authorize.domain.*;
import com.vxianjin.aegis.authorize.dto.ResourceInfo;
import com.vxianjin.aegis.authorize.repository.*;
import com.vxianjin.aegis.authorize.service.BackModuleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhailiang
 *
 */
@Service
public class BackModuleServiceImpl implements BackModuleService {
	
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
	public Set<String> getUrlsByBackUser(String username) {
		BackUser backUser = backUserRepository.findByTelephone(username);
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
		return urls;
	}

	@Override
	public ResourceInfo getInfo(Long id) {
		BackModule backModule = backModuleRepository.findOne(id);
		ResourceInfo resourceInfo = new ResourceInfo();
		BeanUtils.copyProperties(backModule, resourceInfo);
		return resourceInfo;
	}


}
