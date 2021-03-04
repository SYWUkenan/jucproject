package com.kuangshenshuo.juc.jucproject.demo2.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author yswu
 * @date 2021-03-01 15:44
 */
public class ListTest {

    public static void main(String[] args) {


        /**
         * 解决方案：
         * 1.List<String> list = new Vector<>();
         * 2.List<String> list = Collections.synchronizedList(new ArrayList<>());
         * 3.List<String> list = new CopyOnWriteArrayList<>();
         *
         * CopyOnWriteArrayList 读写复制，读写分离的效果。
         *
         */

        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 1;i<=10;i++){

            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);



            },String.valueOf(i)).start();

        }
    }
}
