package com.kuangshenshuo.juc.jucproject.demo3.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yswu
 * @date 2021-03-07 14:35
 */
public class Test1 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                Runtime.getRuntime().availableProcessors(),
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        try{
            for (int i = 1;i<=20;i++) {
                threadPoolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " ok");

                });
            }
        }catch (Exception e) {
            e.printStackTrace();

        }finally {
            threadPoolExecutor.shutdown();
        }


        }



    }

