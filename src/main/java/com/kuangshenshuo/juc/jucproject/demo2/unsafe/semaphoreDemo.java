package com.kuangshenshuo.juc.jucproject.demo2.unsafe;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author yswu
 * @date 2021-03-01 17:08
 */
public class semaphoreDemo {

    public static void main(String[] args) {

        //线程数量：停车位

        Semaphore semaphore = new Semaphore(4);

        for(int i =0;i<6;i++){

        new Thread(
                ()->{
                    //acquire() 得到
                        try {
                            semaphore.acquire();
                            System.out.println(Thread.currentThread().getName()+"抢到车位");
                            TimeUnit.SECONDS.sleep(2);
                            System.out.println(Thread.currentThread().getName()+"离开车位");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            semaphore.release();
                        }

                }

        ,String.valueOf(i)).start();

        }

    }
}
