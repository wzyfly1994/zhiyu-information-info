package com.zhiyu.dao.system;

import com.zhiyu.config.jpa.BaseJpaRepository;
import com.zhiyu.entity.system.SystemPermission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wengzhiyu
 * @date 2020/1/10
 */
@Repository
public interface SystemPermissionRepository extends BaseJpaRepository<SystemPermission, Long> {

    /**
     * findAllByRoleIdIn
     *
     * @param idList
     * @return
     */
    List<SystemPermission> findAllByIdIn(List<Long> idList);
}
