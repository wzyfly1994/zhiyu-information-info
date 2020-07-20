package com.zhiyu.dao.system;

import com.zhiyu.config.jpa.BaseJpaRepository;
import com.zhiyu.entity.system.SystemMenu;
import org.springframework.stereotype.Repository;

/**
 * @author wengzhiyu
 * @date 2020/1/10
 */
@Repository
public interface SystemMenuRepository extends BaseJpaRepository<SystemMenu, Long> {
}
