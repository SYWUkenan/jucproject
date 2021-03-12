package com.kuangshenshuo.juc.jucproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JucprojectApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {


        String name = "wuyusheng";

        //从10输出  10.for
        for (int j = 0; j < 10; j++) {

        }

        for (int m = 0; m < 10; m++) {

        }

        String[] names = {"a","b","c"};

        for (String s : names) {
            System.out.println(s);
        }

        String a = getName();
        System.out.println("Hello world");
    }

    public static String getName(){
        return "wu";
    }

}
