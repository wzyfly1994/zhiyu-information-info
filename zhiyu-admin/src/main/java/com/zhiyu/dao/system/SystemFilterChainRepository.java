package com.zhiyu.dao.system;

import com.zhiyu.config.jpa.BaseJpaRepository;
import com.zhiyu.entity.system.SystemFilterChain;
import org.springframework.stereotype.Repository;

/**
 * @author wengzhiyu
 * @date 2020/6/10
 */
@Repository
public interface SystemFilterChainRepository extends BaseJpaRepository<SystemFilterChain, Long> {
}
