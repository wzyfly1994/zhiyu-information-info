package com.zhiyu.repository;

import com.zhiyu.repository.jpa.BaseJpaRepository;
import com.zhiyu.entity.pojo.system.SystemUserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wengzhiyu
 * @date 2020/01/09
 */
@Repository
public interface SystemUserRoleRepository extends BaseJpaRepository<SystemUserRole, Long> {


    /**
     * findAllByUserId
     * @param userId
     * @return
     */
    List<SystemUserRole>   findAllByUserIdIn(List<Long> userId);

}
