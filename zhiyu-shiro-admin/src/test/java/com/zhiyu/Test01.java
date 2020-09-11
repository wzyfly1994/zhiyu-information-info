package com.zhiyu;

import com.zhiyu.entity.pojo.SystemRole;
import com.zhiyu.repository.SystemRoleRepository;
import com.zhiyu.repository.SystemUserRepository;
import com.zhiyu.repository.SystemUserRoleRepository;
import com.zhiyu.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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
    RedisUtil redisUtil;

    @Test
    public void test() {
        SystemRole systemRole = new SystemRole();
        systemRole.setRoleName("1111");
        SystemRole systemRole1 = systemRoleRepository.save(systemRole);
        System.out.println(systemRole1);




          String a="1";

    }

}
