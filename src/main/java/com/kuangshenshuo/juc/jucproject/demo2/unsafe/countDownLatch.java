package com.kuangshenshuo.juc.jucproject.demo2.unsafe;

import java.util.concurrent.CountDownLatch;

/**
 * @author yswu
 * @date 2021-03-01 16:41
 */
public class countDownLatch {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);

        for(int i = 1;i<=6; i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" Go out");
                countDownLatch.countDown();
            },String.valueOf(i)

            ).start();



        }

        countDownLatch.await();

        System.out.println("close door");

    }
}
