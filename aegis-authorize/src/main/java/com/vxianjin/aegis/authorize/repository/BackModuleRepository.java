/**
 * 
 */
package com.vxianjin.aegis.authorize.repository;

import com.vxianjin.aegis.authorize.domain.BackModule;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author zhailiang
 *
 */
@Repository
public interface BackModuleRepository extends CommonRepository<BackModule> {

	BackModule findByName(String name);

	List<BackModule> findAllByIdIn(Set<Integer> idSet);
}
