/**
 * 
 */
package com.vxianjin.aegis.authorize.repository;

import com.vxianjin.aegis.authorize.domain.BackUserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhailiang
 *
 */
@Repository
public interface BackUserRoleRepository extends CommonRepository<BackUserRole> {
    List<BackUserRole> findAllByUserId(Integer userId);
}
