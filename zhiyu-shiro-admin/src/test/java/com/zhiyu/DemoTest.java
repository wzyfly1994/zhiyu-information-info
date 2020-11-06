package com.zhiyu;


import java.util.concurrent.TimeUnit;

/**
 * @author wengzhiyu
 * @date 2020/1/11
 */
public class DemoTest {


    public static void main(String[] args) {

        long maxTime = TimeUnit.HOURS.toMillis(2);
        long currentTime = System.currentTimeMillis();
        long minTime=TimeUnit.MILLISECONDS.toHours(5400000);
        long minTimess=TimeUnit.HOURS.toMillis(1)+TimeUnit.MINUTES.toMillis(30);
        System.out.println(maxTime);
        System.out.println(currentTime);
        System.out.println(minTime);
        System.out.println(minTimess);

    }


}
