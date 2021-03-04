package com.kuangshenshuo.juc.jucproject.demo2.unsafe;

import java.util.concurrent.FutureTask;

/**
 * @author yswu
 * @date 2021-03-01 16:24
 */
public class Callable {

    public static void main(String[] args) throws Exception{

            MyThread myThread = new MyThread();

        FutureTask futureTask = new FutureTask<>(myThread);

        new Thread(futureTask,"A").start();

        System.out.println(futureTask.get());


    }
}


class MyThread implements java.util.concurrent.Callable{

    @Override
    public Object call()  {
        return "123";
    }
}