package com.zhiyu.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author wengzhiyu
 * @date 2020/12/4
 */
@Slf4j
public class Test01 {

    @Test
    public void test() {

        try {
            int a=1/0;
        } catch (Exception e) {
            log.error("错误",e);
        }

    }
}
