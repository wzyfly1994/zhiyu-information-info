package com.zhiyu.service.system;

import com.zhiyu.entity.system.SystemRole;
import com.zhiyu.entity.system.SystemUser;
import com.zhiyu.entity.system.dto.SystemUserDto;
import com.zhiyu.util.ResponseData;

/**
 * @author wengzhiyu
 * @date 2019/01/07
 */
public interface AboutUserService {

    /**
     * 登陆
     *
     * @param systemUserDto
     * @return
     */
    ResponseData userLogin(SystemUserDto systemUserDto);


    /**
     * 注册
     *
     * @param systemUserDto
     * @return
     */
    ResponseData signIn(SystemUserDto systemUserDto);


    SystemRole queryUserRole(SystemUser user);

}
