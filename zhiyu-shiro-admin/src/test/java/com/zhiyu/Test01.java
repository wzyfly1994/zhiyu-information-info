package com.zhiyu;

import com.zhiyu.entity.pojo.SystemPermission;
import com.zhiyu.repository.SystemPermissionRepository;
import com.zhiyu.repository.SystemRoleRepository;
import com.zhiyu.repository.SystemUserRepository;
import com.zhiyu.repository.SystemUserRoleRepository;
import com.zhiyu.utils.RedisUtil;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author wengzhiyu
 * @date 2020/1/10
 */
@SpringBootTest(classes = ShiroAdminApplication.class)
@RunWith(SpringRunner.class)
public class Test01 {
    @Resource
    private SystemUserRoleRepository systemUserRoleRepository;

    @Resource
    private SystemUserRepository systemUserRepository;
    @Autowired
    private SystemRoleRepository systemRoleRepository;

    @Autowired
    private SystemPermissionRepository systemPermissionRepository;
    @Autowired
    RedisUtil redisUtil;

    @Test
    public void test() {

    }

}
