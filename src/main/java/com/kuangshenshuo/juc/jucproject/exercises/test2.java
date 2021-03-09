package com.kuangshenshuo.juc.jucproject.exercises;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yswu
 * @date 2021-03-08 09:58
 */
public class test2 {

    public static void main(String[] args) {
        TicketNumber ticketNumber = new TicketNumber(20);



            new Thread(()->{
                try {
                    ticketNumber.sale();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            },"A").start();



            new Thread(()->{
                try {
                    ticketNumber.sale();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            },"B").start();


            new Thread(()->{
                try {
                    ticketNumber.sale();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            },"C").start();




    }
}

class TicketNumber{
    private static int number;
    public TicketNumber(int number){
        this.number = number;
    }

    ReentrantLock lock = new ReentrantLock();

    public void sale() throws Exception {


        while(number>0){
            lock.lock();

            try {

                if(number<=0){
                    System.out.println("票已经全部售完");

                }
                else{

                    System.out.println("线程："+Thread.currentThread().getName()+" 卖了1张票,剩余:"+ --number+"票");


                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                Thread.sleep(1000);


            }


        }



    }



}
