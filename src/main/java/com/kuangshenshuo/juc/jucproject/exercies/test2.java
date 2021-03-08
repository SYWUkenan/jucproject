package com.kuangshenshuo.juc.jucproject.exercies;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yswu
 * @date 2021-03-08 09:58
 */
public class test2 {

    public static void main(String[] args) {
        TicketNumber ticketNumber = new TicketNumber(20);

        new Thread(()->{
            ticketNumber.sale();

        },"A").start();


        new Thread(()->{
            ticketNumber.sale();

        },"B").start();


        new Thread(()->{
            ticketNumber.sale();

        },"C").start();

    }
}

class TicketNumber{
    private static int number;
    public TicketNumber(int number){
        this.number = number;
    }

    ReentrantLock lock = new ReentrantLock();

    public void sale(){
        lock.lock();
        while(number>0){

            try {

                if(number<=0){
                    System.out.println("票已经全部售完");

                }
                else{

                    System.out.println("线程："+Thread.currentThread().getName()+" 卖了1张票,剩余:"+ --number+"票");

                    Thread.sleep(1000);


                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }


        }



    }



}
