package com.zhiyu.service.system.impl;

import com.zhiyu.dao.system.SystemRoleRepository;
import com.zhiyu.dao.system.SystemUserRoleRepository;
import com.zhiyu.dao.system.SystemUserRepository;
import com.zhiyu.entity.system.SystemRole;
import com.zhiyu.entity.system.SystemUser;
import com.zhiyu.service.system.SystemLogin;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author wengzhiyu
 * @date 2020/01/08
 */
@Service
public class SystemLoginImpl implements SystemLogin {

    @Resource
    SystemUserRepository userRepository;

    @Resource
    SystemUserRoleRepository userRoleRepository;

    @Resource
    SystemRoleRepository roleRepository;

    @Override
    public SystemUser userLogin(SystemUser user) {
        Optional<SystemUser> optional = userRepository.findOne(Example.of(user));
        return optional.orElse(null);
    }

    @Override
    public SystemRole queryUserRole(SystemUser user) {
        //userRoleRepository.fin
        return null;
    }
}
