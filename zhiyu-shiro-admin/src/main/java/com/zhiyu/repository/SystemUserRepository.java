package com.zhiyu.repository;

import com.zhiyu.repository.jpa.BaseJpaRepository;
import com.zhiyu.entity.pojo.SystemUser;
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