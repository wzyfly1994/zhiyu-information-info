package com.zhiyu;

import cn.hutool.core.date.DateUtil;
import com.zhiyu.dao.system.SystemUserRepository;
import com.zhiyu.dao.system.SystemUserRoleRepository;
import com.zhiyu.entity.system.SystemLoginErrorLog;
import com.zhiyu.entity.system.SystemUser;
import com.zhiyu.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author wengzhiyu
 * @date 2020/1/10
 */
@SpringBootTest(classes = AdminApplication.class)
@RunWith(SpringRunner.class)
public class Test01 {
    @Resource
    private SystemUserRoleRepository systemUserRoleRepository;

    @Resource
    private SystemUserRepository systemUserRepository;

    @Autowired
    RedisUtil redisUtil;


    public void test() {
        SystemLoginErrorLog systemLoginErrorLog = new SystemLoginErrorLog();
        systemLoginErrorLog.setAccount("ucic");
        systemLoginErrorLog.setCreateTime(new Date());
        boolean is = redisUtil.set("er", systemLoginErrorLog);
        System.out.println(is);


        redisUtil.zSet("aa:cc:bb", "1", 3.5);


        Map<String, Object> map = new HashMap<>(3);
        map.put("MapKey1", 123);
        map.put("MapKe2", 321);
        redisUtil.hmset("Map", map);


        List<Integer> list = new ArrayList<>(16);
        list.add(111);
        list.add(222);
        list.add(333);
        redisUtil.lSet("List", list);

        redisUtil.sSet("set", "1", "22");

        long time = 1000L;
        Date date = new Date(time);
        System.out.println(DateUtil.format(date, "HH:mm:ss"));
        String redisKey = "errorLogin:wzy";
        // AtomicInteger errorLoginConut = (AtomicInteger) redisUtil.get(redisKey);
        // AtomicInteger errorLoginConut = new AtomicInteger((Integer) redisUtil.get(redisKey));
        System.out.println(redisUtil.get(redisKey));
    }


//    @Test
//    public void httpTest(HttpServletRequest request) {
//        String seesionId = request.getSession().getId();
//        System.out.println(seesionId);
//    }


    @Test
    public void Test055() {
        Optional<SystemUser> optionalSystemUser = systemUserRepository.findByAccountOrPhone("wzy", "110");
        System.out.println(optionalSystemUser.isPresent());
    }

}
