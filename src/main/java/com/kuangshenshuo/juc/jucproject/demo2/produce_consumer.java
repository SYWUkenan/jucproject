package com.kuangshenshuo.juc.jucproject.demo2;

/**
 * @author yswu
 * @date 2021-02-24 12:09
 */
public class produce_consumer {

    public static void main(String[] args) {

        Data data = new Data();

        new Thread(()->{
            for(int i =0;i<10;i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A"


        ).start();
        new Thread(()->{
            for(int i =0;i<10;i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B"


        ).start();


        new Thread(()->{
            for(int i =0;i<10;i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C"


        ).start();
        new Thread(()->{
            for(int i =0;i<10;i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D"


        ).start();
    }


}



//资源类

/**
 * 判断等待
 * 业务
 * 唤醒
 */
class Data{

    private int number = 0;

    //+1操作

    public synchronized void increment() throws InterruptedException{

        while(number !=0 ){
            //等待
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"-->" + number);

        //唤醒
        this.notifyAll();


    }

    //-1操作

    public synchronized void decrement()  throws InterruptedException{
        while(number==0){
            this.wait();
        }

        number--;
        System.out.println(Thread.currentThread().getName()+"-->" + number);

        this.notifyAll();

    }

}