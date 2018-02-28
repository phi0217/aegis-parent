/**
 * 
 */
package com.vxianjin.aegis.authorize.repository;

import com.vxianjin.aegis.authorize.domain.BackRole;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author zhailiang
 *
 */
@Repository
public interface BackRoleRepository extends CommonRepository<BackRole> {
    List<BackRole> findAllByIdIn(Set<Integer> idSet);
}
