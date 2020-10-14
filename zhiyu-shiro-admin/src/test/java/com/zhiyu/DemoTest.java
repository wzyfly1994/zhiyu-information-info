package com.zhiyu;


import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author wengzhiyu
 * @date 2020/1/11
 */
public class DemoTest {


    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(RandomStringUtils.randomAlphanumeric(32));
        }
    }


}
