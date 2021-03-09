package com.kuangshenshuo.juc.jucproject.lambdaDemo;

import java.util.function.Function;

/**
 * @author yswu
 * @date 2021-03-09 22:39
 */
public class FunctionDemo {

    public static void main(String[] args) {

        Function function = str->{return str;};
        System.out.println(function.apply("wuyusheng"));
    }
}
