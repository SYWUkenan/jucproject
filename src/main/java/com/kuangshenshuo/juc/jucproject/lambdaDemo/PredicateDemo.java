package com.kuangshenshuo.juc.jucproject.lambdaDemo;

import java.util.function.Predicate;

/**
 * @author yswu
 * @date 2021-03-09 22:46
 */
public class PredicateDemo {
    public static void main(String[] args) {

        Predicate<String> objectPredicate = (str)->{
                return str.isEmpty();
        };

        System.out.println(objectPredicate.test("wuyusheng"));
    }
}
