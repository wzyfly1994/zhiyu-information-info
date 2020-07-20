package com.zhiyu.dao.system;

import com.zhiyu.config.jpa.BaseJpaRepository;
import com.zhiyu.entity.system.SystemUser;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author wengzhiyu
 * @date 2020/01/07
 */
@Repository
public interface SystemUserRepository extends BaseJpaRepository<SystemUser, Long> {


    /**
     * 查询账号或手机
     *
     * @param account
     * @param phone
     * @return
     */
    Optional<SystemUser> findByAccountOrPhone(String account, String phone);


}
