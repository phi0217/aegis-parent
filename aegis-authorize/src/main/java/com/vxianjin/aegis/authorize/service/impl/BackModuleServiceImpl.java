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
@Transactional
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


	/* (non-Javadoc)
	 * @see com.idea.ams.service.ResourceService#getResourceTree(java.lang.Long, com.idea.ams.domain.Admin)
	 */
//	@Override
//	public ResourceInfo getTree(Long adminId) {
//		Admin admin = adminRepository.findOne(adminId);
//		return resourceRepository.findByName("根节点").toTree(admin);
//	}

	/* (non-Javadoc)
	 * @see com.vxianjin.aegis.authorize.service.ResourceService#getInfo(java.lang.Long)
	 */

	@Override
	public ResourceInfo getInfo(Long id) {
		BackModule backModule = backModuleRepository.findOne(id);
		ResourceInfo resourceInfo = new ResourceInfo();
		BeanUtils.copyProperties(backModule, resourceInfo);
		return resourceInfo;
	}

//	@Override
//	public ResourceInfo create(ResourceInfo info) {
//		Resource parent = resourceRepository.findOne(info.getParentId());
//		if(parent == null){
//			parent = resourceRepository.findByName("根节点");
//		}
//		Resource resource = new Resource();
//		BeanUtils.copyProperties(info, resource);
//		parent.addChild(resource);
//		info.setId(resourceRepository.save(resource).getId());
//		return info;
//	}

	@Override
	public ResourceInfo update(ResourceInfo info) {
		BackModule backModule = backModuleRepository.findOne(info.getId());
		BeanUtils.copyProperties(info, backModule);
		return info;
	}

	@Override
	public void delete(Long id) {
		backModuleRepository.delete(id);
	}
	/* (non-Javadoc)
	 * @see com.vxianjin.aegis.authorize.service.ResourceService#move(java.lang.Long, boolean)
	 */
//	@Override
//	public Long move(Long id, boolean up) {
//		BackModule backModule = resourceRepository.findOne(id);
//		int index = backModule.getSort();
//		List<BackModule> childs = backModule.getParent().getChilds();
//		for (int i = 0; i < childs.size(); i++) {
//			BackModule current = childs.get(i);
//			if(current.getId().equals(id)) {
//				if(up){
//					if(i != 0) {
//						BackModule pre = childs.get(i - 1);
//						backModule.setSort(pre.getSort());
//						pre.setSort(index);
//						resourceRepository.save(pre);
//					}
//				}else{
//					if(i != childs.size()-1) {
//						BackModule next = childs.get(i + 1);
//						backModule.setSort(next.getSort());
//						next.setSort(index);
//						resourceRepository.save(next);
//					}
//				}
//			}
//		}
//		resourceRepository.save(backModule);
//		return backModule.getParent().getId();
//	}

}
