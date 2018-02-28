/**
 * 
 */
package com.vxianjin.aegis.authorize.repository.spec;

import com.vxianjin.aegis.authorize.domain.BackUser;
import com.vxianjin.aegis.authorize.dto.AdminCondition;
import com.vxianjin.aegis.authorize.repository.support.CommonSpecification;
import com.vxianjin.aegis.authorize.repository.support.QueryWraper;

/**
 * @author zhailiang
 *
 */
public class AdminSpec extends CommonSpecification<BackUser, AdminCondition> {

	public AdminSpec(AdminCondition condition) {
		super(condition);
	}

	@Override
	protected void addCondition(QueryWraper<BackUser> queryWraper) {
		addLikeCondition(queryWraper, "username");
	}

}
