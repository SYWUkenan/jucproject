package com.kuangshenshuo.juc.jucproject.lambdaDemo;

import java.util.function.Consumer;

/**
 * @author yswu
 * @date 2021-03-09 22:52
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> consumer = (str)->{

            System.out.println(str);
        };

        consumer.accept("wuyusheng");
    }
}
