package com.kuangshenshuo.juc.jucproject.demo1;

/**
 * @author yswu
 * @date 2021-02-24 10:48
 */
public class test2 {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();


        //@FunctionInterface 函数式接口,jdk1.8 lambda表达式 (方法参数)->{代码}
        new Thread(
                ()->{

                    for(int i=1;i<60;i++){
                        ticket.sale();
                    }


                },"A"
        ).start();
        new Thread(
                ()->{
                    for(int i=1;i<60;i++){
                        ticket.sale();
                    }
                },"B"
        ).start();
        new Thread(
                ()->{
                    for(int i=1;i<60;i++){
                        ticket.sale();
                    }

                },"C"
        ).start();
    }

}
class Ticket{
    private int number = 100;

    //卖票的方式
    public synchronized void sale(){
        if(number>0){
            System.out.println(Thread.currentThread().getName()+"票数："+( number--) + "卖完了,剩余" + number);
        }
    }
}
