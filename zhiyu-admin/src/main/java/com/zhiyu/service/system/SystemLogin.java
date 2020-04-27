package com.zhiyu.service.system;

import com.zhiyu.entity.system.SystemRole;
import com.zhiyu.entity.system.SystemUser;

/**
 * @author wengzhiyu
 * @date 2019/01/07
 */
public interface SystemLogin {

    /**
     * userLogin
     * @param userr
     * @return
     */
    SystemUser userLogin(SystemUser userr);


    SystemRole queryUserRole(SystemUser user);

}
