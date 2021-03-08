package com.kuangshenshuo.juc.jucproject.exercies;

/**
 * @author yswu
 * @date 2021-03-07 22:34
 */
public class test1 {

    public static void main(String[] args) {
        TicketOffice ticket = new TicketOffice(20);

        new Thread(()->{
            ticket.sale();

        },"A").start();

        new Thread(()->{
            ticket.sale();

        },"B").start();

        new Thread(()->{
            ticket.sale();

        },"C").start();


    }





}


class TicketOffice{

    private static int number;

    public TicketOffice(int number){
        this.number = number;
    }

    public void sale(){

    while(number>0){
      synchronized (TicketOffice.class) {

          if (number <=0) {
              System.out.println("票已经售完！");

          } else {
              System.out.println("当前线程:" + Thread.currentThread().getName() + "卖了1一张票，剩余" + --number + "票");

              try {
                  Thread.sleep(100);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }

          }

      }
     }
     }

}
