package com.zhiyu.service;

import com.zhiyu.entity.dto.SystemUserDto;
import com.zhiyu.utils.ResponseData;

/**
 * @author wengzhiyu
 * @date 2019/01/07
 */
public interface SystemService {

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


}
