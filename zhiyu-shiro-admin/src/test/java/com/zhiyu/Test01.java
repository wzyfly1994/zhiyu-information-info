package com.zhiyu;

import com.zhiyu.repository.*;
import com.zhiyu.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
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
    private SystemPermissionRepository systemPermissionRepository;
    @Autowired
    private SystemDepartmentRepository systemDepartmentRepository;
    @Autowired
    private SystemRolePermissionRepository systemRolePermissionRepository;
    @Autowired
    private SystemMenuRepository systemMenuRepository;
    @Autowired
    RedisUtil redisUtil;
    @Resource
    private RedissonClient redissonClient;

    @Test
    public void test() {
//        RDeque<String> deque = redissonClient.getDeque("ABC");
//        deque.push("A");
//        deque.push("B");
//        deque.removeLast();
//        System.out.println(deque.size());
//        RBucket<String> bucket = redissonClient.getBucket("BBB");
//        bucket.set("CC");
//        bucket.set("CC");
String aa="5";
        RLock rLock = redissonClient.getLock("33333");
        rLock.lock();
        rLock.unlock();
    }

}
