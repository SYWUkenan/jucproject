package com.kuangshenshuo.juc.jucproject.demo1;

/**
 * @author yswu
 * @date 2021-02-24 10:45
 */

public class test1 {
    public static void main(String[] args) {
        //获取cpu的核数
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
