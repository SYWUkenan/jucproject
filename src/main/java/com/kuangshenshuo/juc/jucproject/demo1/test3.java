package com.kuangshenshuo.juc.jucproject.demo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yswu
 * @date 2021-02-24 10:48
 */
public class test3 {

    public static void main(String[] args) {
        Ticket3 ticket = new Ticket3();


        //@FunctionInterface 函数式接口,jdk1.8 lambda表达式 (方法参数)->{代码}
        new Thread(()->{ for(int i=1;i<60;i++) ticket.sale(); },"A").start();
        new Thread(()->{ for(int i=1;i<60;i++) ticket.sale(); },"B").start();
        new Thread(()->{ for(int i=1;i<60;i++) ticket.sale(); },"C").start();


    }

}

/**Lock三部曲
 *
 * 1.new ReentrantLock
 * 2.lock.unlock
 */

class Ticket3{
    private int number = 100;

    Lock lock = new ReentrantLock();



    //卖票的方式
    //</editor-fold>
    public  void sale(){

        lock.lock();

        try{
            if(number>0){
                System.out.println(Thread.currentThread().getName()+"票数："+( number--) + "卖完了,剩余" + number);
            }

        }catch(Exception e){

            e.printStackTrace();
        }finally{
//            lock.unlock();
        }

    }
}
