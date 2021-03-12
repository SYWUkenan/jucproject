package com.kuangshenshuo.juc.jucproject.demo1;

import java.util.ArrayList;

/**
 * @author yswu
 * @date 2021-02-24 10:45
 */

public class test1 {
    public static void main(String[] args) {
        ArrayList<String > list = new ArrayList<>();

//        new ArrayList<>();
        list.add("asfd");
        list.add("asdd");
        list.add("assdd");

        for (String s : list) {
            System.out.println("s = " + s);
        }

        for (int i = 0; i < list.size(); i++) {


        }
    }



}
