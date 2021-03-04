package com.kuangshenshuo.juc.jucproject.demo2.unsafe;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author yswu
 * @date 2021-03-01 16:52
 */
public class CyclicBarrierDemo {


    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙成功");
        });


        for(int i = 1;i<=7;i++){
            final int temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集"
                +temp+"个龙珠");

                try {
                    cyclicBarrier.await(); //等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }).start();

        }

    }
}
