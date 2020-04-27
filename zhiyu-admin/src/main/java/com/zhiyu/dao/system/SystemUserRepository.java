package com.zhiyu.dao.system;

import com.zhiyu.config.jpa.BaseJpaRepository;
import com.zhiyu.entity.system.SystemUser;
import org.springframework.stereotype.Repository;

/**
 * @author wengzhiyu
 * @date 2020/01/07
 */
@Repository
public interface SystemUserRepository extends BaseJpaRepository<SystemUser, Long> {
}
