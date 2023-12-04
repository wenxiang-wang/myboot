package com.javaproperty.lambda;

public class Mytets {

    public static void main(String[] args) {
        NormalTest.mytest(str -> {
            System.out.println(str);
        }, "hello lambda");

    }

}
