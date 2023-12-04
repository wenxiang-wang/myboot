package com.javaproperty.lambda;

import java.util.Arrays;
import java.util.List;

public interface NormalTest {

    static void mytest(LambdaFormula lam, String one) {
        lam.one(one);

        List<Integer> primes = Arrays.asList(new Integer[]{2, 3, 5, 7});
        primes.forEach(element -> System.out.println(element));
    }
}
