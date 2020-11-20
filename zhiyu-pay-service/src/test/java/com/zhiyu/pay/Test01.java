package com.zhiyu.pay;

import com.zhiyu.pay.config.PayConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = PayServiceApplication.class)
@RunWith(SpringRunner.class)
class Test01 {

    @Autowired
    private PayConfig payConfig;
    @Test
    void contextLoads() {
        System.out.println(payConfig.getSignType());
    }

}
