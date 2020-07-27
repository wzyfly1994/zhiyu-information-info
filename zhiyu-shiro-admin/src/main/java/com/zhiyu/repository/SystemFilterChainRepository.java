package com.zhiyu.repository;

import com.zhiyu.config.jpa.BaseJpaRepository;
import com.zhiyu.entity.pojo.SystemFilterChain;
import org.springframework.stereotype.Repository;

/**
 * @author wengzhiyu
 * @date 2020/6/10
 */
@Repository
public interface SystemFilterChainRepository extends BaseJpaRepository<SystemFilterChain, Long> {
}
