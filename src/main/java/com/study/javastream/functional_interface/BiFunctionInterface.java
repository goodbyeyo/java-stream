package com.study.javastream.functional_interface;

import java.util.function.BiFunction;

public class BiFunctionInterface {
    public static void main(String[] args) {
        multiply(5, 10);
    }

    private static void multiply(int num1, int num2) {
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x * y;
        Integer result = add.apply(num1, num2);
        System.out.printf("%d * %d = %d%n", num1, num2, result);
    }
}
