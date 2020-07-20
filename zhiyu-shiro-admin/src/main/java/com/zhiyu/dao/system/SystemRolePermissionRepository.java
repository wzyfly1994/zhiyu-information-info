package com.zhiyu.dao.system;

import com.zhiyu.config.jpa.BaseJpaRepository;
import com.zhiyu.entity.system.SystemRolePermission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wengzhiyu
 * @date 2020/1/10
 */
@Repository
public interface SystemRolePermissionRepository extends BaseJpaRepository<SystemRolePermission, Long> {


    /**
     * findAllByRoleIdIn
     *
     * @param roleList
     * @return
     */
    List<SystemRolePermission> findAllByRoleIdIn(List<Long> roleList);
}
