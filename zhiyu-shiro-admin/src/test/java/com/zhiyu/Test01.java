package com.zhiyu;

import com.alibaba.fastjson.JSON;
import com.zhiyu.repository.*;
import com.zhiyu.utils.RedisUtil;
import com.zhiyu.utils.tree.TreeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

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
    private SystemDepartmentRepository systemDepartmentRepository;
    @Autowired
    RedisUtil redisUtil;

    @Test
    public void test() {
        List list = TreeUtil.listToTree(0L, systemDepartmentRepository.findAll());
        System.out.println(list);
        System.out.println(JSON.toJSONString(list));
    }

}
