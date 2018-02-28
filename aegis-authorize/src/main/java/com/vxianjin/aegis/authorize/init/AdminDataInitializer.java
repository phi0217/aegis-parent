/**
 * 
 */
package com.vxianjin.aegis.authorize.init;

import com.vxianjin.aegis.authorize.domain.*;
import com.vxianjin.aegis.authorize.repository.BackUserRepository;
import com.vxianjin.aegis.authorize.repository.BackModuleRepository;
import com.vxianjin.aegis.authorize.repository.BackUserRoleRepository;
import com.vxianjin.aegis.authorize.repository.BackRoleRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * 默认的系统数据初始化器，永远在其他数据初始化器之前执行
 * 
 * @author zhailiang
 *
 */
@Component
public class AdminDataInitializer extends AbstractDataInitializer {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private BackRoleRepository backRoleRepository;

	@Autowired
	private BackUserRepository backUserRepository;

	@Autowired
	private BackUserRoleRepository backUserRoleRepository;

	@Autowired
	protected BackModuleRepository backModuleRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.idea.core.spi.initializer.DataInitializer#getIndex()
	 */
	@Override
	public Integer getIndex() {
		return Integer.MIN_VALUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.idea.core.spi.initializer.AbstractDataInitializer#doInit()
	 */
	@Override
	protected void doInit() {
		initResource();
		BackRole backRole = initRole();
		initAdmin(backRole);
	}

	/**
	 * 初始化用户数据
	 * 
	 * @param backRole
	 */
	private void initAdmin(BackRole backRole) {
		BackUser backUser = new BackUser();
		backUser.setName("admin");
		backUser.setPassword(passwordEncoder.encode("123456"));
		backUserRepository.save(backUser);

		BackUserRole backUserRole = new BackUserRole();
		backUserRole.setRoleId(backRole.getId());
		backUserRole.setUserId(backUser.getId());
		backUserRoleRepository.save(backUserRole);
	}

	/**
	 * 初始化角色数据
	 * 
	 * @return
	 */
	private BackRole initRole() {
		BackRole backRole = new BackRole();
		backRole.setName("超级管理员");
		backRoleRepository.save(backRole);
		return backRole;
	}

	/**
	 * 初始化菜单数据
	 */
	protected void initResource() {
		BackModule root = createRoot("根节点");

		createResource("首页", "", "home", root);

		BackModule menu1 = createResource("平台管理", "", "desktop", root);

//		createResource("资源管理", "resource", "", menu1);
		createResource("角色管理", "role", "", menu1);
		createResource("管理员管理", "admin", "", menu1);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.idea.core.spi.initializer.AbstractDataInitializer#isNeedInit()
	 */
	@Override
	protected boolean isNeedInit() {
		return backUserRepository.count() == 0;
	}

	/**
	 * @param name
	 * @return
	 */
	protected BackModule createRoot(String name) {
		BackModule node = new BackModule();
		node.setName(name);
		backModuleRepository.save(node);
		return node;
	}

	/**
	 * @param name
	 * @param parent
	 * @return
	 */
	protected BackModule createResource(String name, BackModule parent) {
		return createResource(name, null, null, parent);
	}

	/**
	 * @param name
	 * @param link
	 * @param iconName
	 * @param parent
	 * @return
	 */
	protected BackModule createResource(String name, String link, String iconName, BackModule parent) {
		BackModule node = new BackModule();
		node.setName(name);
		node.setParentId(parent.getId());
		node.setType(BackModuleType.MENU);
		if (StringUtils.isNotBlank(link)) {
			node.setUrl(link + "Manage");
			Set<String> urls = new HashSet<>();
			urls.add(link + "Manage");
			urls.add("/" + link + "/**");
		}
		backModuleRepository.save(node);
		return node;
	}
}
