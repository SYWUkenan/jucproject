package com.kuangshenshuo.juc.jucproject.demo2.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yswu
 * @date 2021-03-01 14:24
 */
public class produce_consumer2 {

    public static void main(String[] args) {
        Data3 data = new Data3();

        new Thread(()->{
            for (int i =0 ;i<10;i++){
                data.printA();
            }


        },"A").start();

        new Thread(()->{
            for (int i =0 ;i<10;i++){
                data.printB();
            }

        },"B").start();

        new Thread(()->{
            for (int i =0 ;i<10;i++){
                data.printC();
            }


        },"C").start();




    }









}





/**
 * 判断等待
 * 业务
 * 唤醒
 */
class Data3{


   private Lock lock = new ReentrantLock();
   private Condition condition1 = lock.newCondition();
   private Condition condition2 = lock.newCondition();
   private Condition condition3 = lock.newCondition();
   private int number = 1;

    public void printA(){

        lock.lock();
        try {
            while(number!=1){
                //等待
                condition1.await();
            }

            System.out.println(Thread.currentThread().getName()+"---->AAAA");
            //唤醒 B
            number = 2;
            condition2.signalAll();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }
    public void printB(){
        lock.lock();
        try {

            while(number!=2){
                condition2.await();

            }
            System.out.println(Thread.currentThread().getName()+"---->BBBB");

            //唤醒C
            number=3;
            condition3.signalAll();




        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }
    public void printC(){
        lock.lock();

        try {
            while(number!=3){
                condition3.await();

            }
            System.out.println(Thread.currentThread().getName()+"---->CCCC");

            //唤醒A
            number = 1;
            condition1.signalAll();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }






}