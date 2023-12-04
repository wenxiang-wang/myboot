package com.javaproperty.lambda;

/***
 * lambda表达四使用的必要条件
 * 函数式接口
 *      特点：
 *           1.使用@FunctionalInterface注解标识
 *           2.只有一个抽象方法
 */

@FunctionalInterface
public interface LambdaFormula<T> {


    void one(T t);

    default void two(String str) {
        System.out.println(" my LambdaFormula ");
    }
}
