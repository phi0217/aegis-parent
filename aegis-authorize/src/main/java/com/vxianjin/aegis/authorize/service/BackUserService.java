package com.vxianjin.aegis.authorize.service;

import com.vxianjin.aegis.authorize.domain.BackUser;

/**
 * @author xiefei
 * @date 2018/03/08
 */
public interface BackUserService {
    BackUser getBackUser(String telephone);
}
