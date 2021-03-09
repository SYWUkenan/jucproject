package com.kuangshenshuo.juc.jucproject.demo2;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author yswu
 * @date 2021-03-09 11:15
 */
public class test {

    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        TreeMap<Integer,Integer> res = new TreeMap<>();
        map.put(2,1);
        map.put(1,2);
        map.put(3,5);
        map.put(5,3);
        map.put(8,4);
        map.put(4,8);
        map.put(12,6);
        map.put(9,7);
        map.put(7,9);
        map.put(11,10);

        for(Integer tmp:map.keySet()){
            res.put(map.get(tmp),tmp);
            }

        for (Integer i:res.keySet()){
            System.out.println("("+res.get(i)+","+i+")");
        }



        }
}


