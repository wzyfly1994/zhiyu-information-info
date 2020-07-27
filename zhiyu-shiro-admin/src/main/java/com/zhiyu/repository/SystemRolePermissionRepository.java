package com.zhiyu.repository;

import com.zhiyu.repository.jpa.BaseJpaRepository;
import com.zhiyu.entity.pojo.SystemRolePermission;
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
