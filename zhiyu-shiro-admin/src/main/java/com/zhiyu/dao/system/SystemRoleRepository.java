package com.zhiyu.dao.system;

import com.zhiyu.config.jpa.BaseJpaRepository;
import com.zhiyu.entity.system.SystemRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wengzhiyu
 * @date 2020/01/09
 */
@Repository
public interface SystemRoleRepository extends BaseJpaRepository<SystemRole, Long> {


    /**
     * findAllByIdIn
     *
     * @param id
     * @return
     */
    List<SystemRole> findAllByIdIn(List<Long> id);
}
