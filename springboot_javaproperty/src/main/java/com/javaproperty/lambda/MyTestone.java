package com.javaproperty.lambda;

import java.util.Comparator;

public class MyTestone {
    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        System.out.println(comparator.compare(20, 12));//1

        Comparator<Integer> comparator1 = Integer::compareTo;
        System.out.println(comparator1.compare(20, 12));//1
    }

}
