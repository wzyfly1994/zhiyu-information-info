package com.zhiyu.repository;

import com.zhiyu.config.jpa.BaseJpaRepository;
import com.zhiyu.entity.pojo.SystemMenu;
import org.springframework.stereotype.Repository;

/**
 * @author wengzhiyu
 * @date 2020/1/10
 */
@Repository
public interface SystemMenuRepository extends BaseJpaRepository<SystemMenu, Long> {
}
