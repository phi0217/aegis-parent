/**
 * 
 */
package com.vxianjin.aegis.authorize.repository;

import com.vxianjin.aegis.authorize.domain.BackUser;
import org.springframework.stereotype.Repository;

/**
 * @author zhailiang
 *
 */
@Repository
public interface BackUserRepository extends CommonRepository<BackUser> {

	BackUser findByTelephone(String telephone);

}
