package suanfa.interview;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/****
 * 两个线程分别打印0-100之间的奇偶数
 * @author youqiang.xiong
 * <p> TODO 简单描述此类的用途</p>
 * 2018年2月25日下午6:18:34
 */
public class ThreadPrintData {
    private static final Object lock = new Object();
    private static volatile Integer i = 0;
    private static final int TOTAL = 1000000;
    public static CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread("奇数线程") {

            @Override
            public void run() {
                while (i <= TOTAL) synchronized (lock) {
                    if (i % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + "打印：   " + i++);
                    } else {
                        lock.notify();
                        try {
                            if (i <= TOTAL) {
                                lock.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println(Thread.currentThread().getName() + " finished!!!");
            }
        };

        Thread thread2 = new Thread("偶数线程") {

            @Override
            public void run() {
                while (i <= TOTAL) synchronized (lock) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "打印：  " + i++);
                        if (i > TOTAL) {
                            lock.notify();
                        }
                    } else {
                        lock.notify();
                        try {
                            if (i < TOTAL) {
                                lock.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println(Thread.currentThread().getName() + " finished!!!");
            }
        };
        long start = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        thread2.join();
        long end = System.currentTimeMillis();
        System.out.println("1.共耗时:" + (end - start) + "ms");//1.共耗时:9159ms
//        test2();
    }


    private static volatile boolean flag = true; //奇数 false

    private static AtomicInteger num = new AtomicInteger();

    public static void test2() throws InterruptedException {

        long start = System.currentTimeMillis();


        Thread jsThread = new Thread(new Runnable() {

            @Override
            public void run() {

                while (num.get() <= TOTAL - 1) {
                    if (!flag) {
                        System.out.println(Thread.currentThread().getName() + "打印: " + num.getAndIncrement());
                        flag = true;
                    }
                }

                latch.countDown();

            }
        });

        jsThread.setName("奇数线程");

        Thread osThread = new Thread(new Runnable() {

            @Override
            public void run() {

                while (num.get() <= TOTAL) {
                    if (flag) {
                        System.out.println(Thread.currentThread().getName() + "打印： " + num.getAndIncrement());
                        flag = false;
                    }
                }

                latch.countDown();
            }
        });

        osThread.setName("偶数线程");

        osThread.start();
        jsThread.start();

        latch.await();
        long end = System.currentTimeMillis();

        System.out.println("一共耗时：" + (end - start) + "ms");//2.共耗时:3159ms

    }

}
