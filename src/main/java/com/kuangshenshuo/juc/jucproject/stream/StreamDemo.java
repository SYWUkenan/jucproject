package com.kuangshenshuo.juc.jucproject.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author yswu
 * @date 2021-03-09 23:15
 */
public class StreamDemo {

    public static void main(String[] args) {
        User u1 = new User(1, "a", 21);
        User u2 = new User(2, "b", 12);
        User u3 = new User(3, "c", 6);
        User u4 = new User(4, "d", 40);
        User u5 = new User(5, "e", 32);
        User u6 = new User(6, "f", 9);


        List<User> list = Arrays.asList(u1, u2, u3, u4, u5, u6);

        //计算交给Stream流
        list.stream().filter(u->{return u.getId()%2==0;})
                .filter(u->{return u.getAge()>10;})
                .map(u->{return u.getName().toUpperCase(); })
                .sorted((uu1,uu2)->{return uu2.compareTo(uu1);}).forEach(System.out::println);
    }

}
