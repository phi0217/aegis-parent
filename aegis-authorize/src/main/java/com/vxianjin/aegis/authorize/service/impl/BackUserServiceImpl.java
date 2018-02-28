/**
 * 
 */
package com.vxianjin.aegis.authorize.service.impl;

import com.vxianjin.aegis.authorize.domain.BackUser;
import com.vxianjin.aegis.authorize.domain.BackUserRole;
import com.vxianjin.aegis.authorize.dto.AdminCondition;
import com.vxianjin.aegis.authorize.dto.AdminInfo;
import com.vxianjin.aegis.authorize.repository.BackUserRepository;
import com.vxianjin.aegis.authorize.repository.BackUserRoleRepository;
import com.vxianjin.aegis.authorize.repository.BackRoleRepository;
import com.vxianjin.aegis.authorize.repository.spec.AdminSpec;
import com.vxianjin.aegis.authorize.repository.support.QueryResultConverter;
import com.vxianjin.aegis.authorize.service.BackUserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhailiang
 *
 */
@Service
@Transactional
public class BackUserServiceImpl implements BackUserService {
	
	@Autowired
	private BackUserRepository backUserRepository;
	
	@Autowired
	private BackRoleRepository backRoleRepository;
	
	@Autowired
	private BackUserRoleRepository backUserRoleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	/* (non-Javadoc)
	 * @see com.vxianjin.aegis.authorize.service.AdminService#create(com.vxianjin.aegis.authorize.dto.AdminInfo)
	 */
//	@Override
//	public AdminInfo create(AdminInfo adminInfo) {
//
//		BackUser backUser = new BackUser();
//		BeanUtils.copyProperties(adminInfo, backUser);
//		backUser.setPassword(passwordEncoder.encode("123456"));
//		backUserRepository.save(backUser);
//		adminInfo.setId(backUser.getId());
//
//		createRoleAdmin(adminInfo, backUser);
//
//		return adminInfo;
//	}
//
//	/* (non-Javadoc)
//	 * @see com.vxianjin.aegis.authorize.service.AdminService#update(com.vxianjin.aegis.authorize.dto.AdminInfo)
//	 */
//	@Override
//	public AdminInfo update(AdminInfo adminInfo) {
//
//		BackUser backUser = backUserRepository.findOne(adminInfo.getId());
//		BeanUtils.copyProperties(adminInfo, backUser);
//
//		createRoleAdmin(adminInfo, backUser);
//
//		return adminInfo;
//	}
//
//	/**
//	 * 创建角色用户关系数据。
//	 */
//	private void createRoleAdmin(AdminInfo adminInfo, BackUser backUser) {
//		if(CollectionUtils.isNotEmpty(backUser.getRoles())){
//			backUserRoleRepository.delete(backUser.getRoles());
//		}
//		BackUserRole backUserRole = new BackUserRole();
//		backUserRole.setBackRole(backRoleRepository.getOne(adminInfo.getRoleId()));
//		backUserRole.setBackUser(backUser);
//		backUserRoleRepository.save(backUserRole);
//	}
//
//	/* (non-Javadoc)
//	 * @see com.vxianjin.aegis.authorize.service.AdminService#delete(java.lang.Long)
//	 */
//	@Override
//	public void delete(Long id) {
//		backUserRepository.delete(id);
//	}
//
//	/* (non-Javadoc)
//	 * @see com.vxianjin.aegis.authorize.service.AdminService#getInfo(java.lang.Long)
//	 */
//	@Override
//	public AdminInfo getInfo(Long id) {
//		BackUser backUser = backUserRepository.findOne(id);
//		AdminInfo info = new AdminInfo();
//		BeanUtils.copyProperties(backUser, info);
//		return info;
//	}
//
//	/* (non-Javadoc)
//	 * @see com.vxianjin.aegis.authorize.service.AdminService#query(com.vxianjin.aegis.authorize.dto.AdminInfo, org.springframework.data.domain.Pageable)
//	 */
//	@Override
//	public Page<AdminInfo> query(AdminCondition condition, Pageable pageable) {
//		Page<BackUser> admins = backUserRepository.findAll(new AdminSpec(condition), pageable);
//		return QueryResultConverter.convert(admins, AdminInfo.class, pageable);
//	}

}
