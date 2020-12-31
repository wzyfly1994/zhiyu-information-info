package com.zhiyu.common;

/**
 * @author wengzhiyu
 * @date 2020/12/22
 */
public class Test02 {


//    @Test
//    public void test() {
//
//    }

    public static void main(String[] args) throws InterruptedException {


    }

    static class ThreadDemo implements Runnable {
        int num = 100;

        @Override
        public void run() {
            try {
                while (true) {
                    if (num > 0) {
                      //  TimeUnit.SECONDS.sleep(2);
                       // synchronized (this) {
                            System.out.println(Thread.currentThread().getName() + "砍了----" + num + "---执行了");
                            num--;
                        //}
                    }
                    if (num <= 0) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
