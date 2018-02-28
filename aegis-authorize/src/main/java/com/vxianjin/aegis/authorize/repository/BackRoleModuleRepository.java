package com.vxianjin.aegis.authorize.repository;


import com.vxianjin.aegis.authorize.domain.BackRoleModule;

import java.util.List;
import java.util.Set;

/**
 * @author xiefei
 * @date 2018/02/28
 */
public interface BackRoleModuleRepository  extends CommonRepository<BackRoleModule> {
    List<BackRoleModule> findAllByRoleIdIn(Set<Integer> idSet);
}
