package org.myreflex;

import java.util.Properties;

public class Mytest {
    public static void main(String[] args) {
        Class properties = Properties.class;
        System.out.println(Properties.class);
        System.out.println(properties.getName());
        System.out.println(properties.getSigners());
        System.out.println(properties.getCanonicalName());
        System.out.println(properties.getInterfaces());
        System.out.println(properties.getFields());
    }
}
