package com.zhiyu.repository;

import com.zhiyu.entity.pojo.SystemMenu;
import com.zhiyu.repository.jpa.BaseJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wengzhiyu
 * @date 2020/1/10
 */
@Repository
public interface SystemMenuRepository extends BaseJpaRepository<SystemMenu, Long> {


    /**
     * findAllByOrOrderBySerialNumAsc
     *
     * @return
     */
    List<SystemMenu>   findAllByOrderBySerialNumAsc();
}
