package com.gzd.chapter11;

import java.util.concurrent.*;

/**
 * @author gzd
 * @date create in 2019/8/5 21:57
 * 条目81：并发工具优先于wait和notify
 * 实现一个基于并发的 计数器。
 **/
public class ConcurrentUtil {

    public static long time(Executor executor,int concurrency,Runnable runnable) throws InterruptedException {

        final CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);
        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                System.out.println("开始准备。。。。");
                ready.countDown();
                try {
                    System.out.println("等待开始。。。");
                    start.await();
                    runnable.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }  finally {
                    System.out.println("调用结束线程。。。");
                    done.countDown();
                }


            });
        }

        ready.await();
        long startNanos = System.nanoTime();
        start.countDown();
        System.out.println("等待结束。。。");
        done.await();

        return System.nanoTime() - startNanos;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("执行run方法");

            }
        };
        Executor executor = Executors.newCachedThreadPool();
        long num = time(executor,10,runnable);
        System.out.println(num);
    }
}
