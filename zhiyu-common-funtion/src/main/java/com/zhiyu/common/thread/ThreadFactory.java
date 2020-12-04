package com.zhiyu.common.thread;

import java.util.concurrent.ExecutorService;

/**
 * 线程工厂
 *
 * @author wengzhiyu
 * @date 2020/06/23 16:05
 */
public class ThreadFactory {

    private static ExecutorService sendSmsExecutor;

    private static ExecutorService asyncExecutor;

    private ThreadFactory() {
    }

    /**
     * 初始化线程池
     */
    public static void init(){
        if (sendSmsExecutor == null || asyncExecutor ==null){
            synchronized (ThreadFactory.class){
                if (sendSmsExecutor == null) {
                    sendSmsExecutor = ThreadPoolFactory.createFixedThreadPool(desiredThreadNum(), "sendSmsThread");
                }
                if(asyncExecutor == null){
                    asyncExecutor = ThreadPoolFactory.createFixedThreadPool(desiredThreadNum() / 2, "asyncThread");
                }
            }
        }
    }

    public static ExecutorService getSendSmsExecutor() {
        return sendSmsExecutor;
    }

    public static ExecutorService getAsyncExecutor() {
        return asyncExecutor;
    }


    /**
     * 理想的线程数，使用 2倍cpu核心数
     */
    public static int desiredThreadNum() {
        return Runtime.getRuntime().availableProcessors() * 2;
    }
}
