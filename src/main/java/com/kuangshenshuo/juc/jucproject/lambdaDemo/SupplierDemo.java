package com.kuangshenshuo.juc.jucproject.lambdaDemo;

import java.util.function.Supplier;

/**
 * @author yswu
 * @date 2021-03-09 22:57
 */
public class SupplierDemo {
    public static void main(String[] args) {

       Supplier supplier = ()->{
           return "wuyusheng";
       };

        System.out.println(supplier.get());
    }
}
