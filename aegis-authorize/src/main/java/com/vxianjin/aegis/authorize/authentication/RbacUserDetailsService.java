/**
 * 
 */
package com.vxianjin.aegis.authorize.authentication;

import com.vxianjin.aegis.authorize.domain.BackUser;
import com.vxianjin.aegis.authorize.repository.BackUserRepository;
import com.vxianjin.aegis.authorize.service.BackModuleService;
import com.vxianjin.aegis.authorize.service.BackUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhailiang
 *
 */
@Component
@Transactional
public class RbacUserDetailsService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BackUserRepository backUserRepository;
	@Autowired
	private BackUserService backUserService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("表单登录用户名:" + username);
		BackUser backUser = backUserService.getBackUser(username);
		return backUser;
	}

}
