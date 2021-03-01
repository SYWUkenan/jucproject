package com.kuangshenshuo.juc.jucproject.demo2.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yswu
 * @date 2021-03-01 13:55
 */
public class produce_consumer {
    public static void main(String[] args) {
        Data2 data = new Data2();

        new Thread(()->{

            for(int i =0;i<10;i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        ,"A").start();

        new Thread(()->{
            for(int i =0;i<10;i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


                ,"B").start();

        new Thread(()->{
            for(int i =0;i<10;i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


                ,"C").start();

        new Thread(()->{
            for(int i =0;i<10;i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


                ,"D").start();


    }


}



//资源类

/**
 * 判断等待
 * 业务
 * 唤醒
 */
class Data2{

    private int number = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

//condition.signal();

    //+1操作

    public  void increment() throws InterruptedException{

        lock.lock();
        try {
            //业务逻辑代码
            while(number !=0 ){
                //等待
                condition.await();

            }
            number++;
            System.out.println(Thread.currentThread().getName()+"-->" + number);

            //唤醒
            condition.signalAll();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {


            lock.unlock();
        }





    }

    //-1操作

    public  void decrement()  throws InterruptedException{
        lock.lock();
        try {

            while(number==0){
                condition.await();

            }

            number--;
            System.out.println(Thread.currentThread().getName()+"-->" + number);
            condition.signalAll();
        } catch (Exception e) {


        } finally {

            lock.unlock();
        }




    }


}
