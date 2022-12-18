package com.study.javastream.functional_interface;

import java.util.function.Function;

public class FunctionInterface {
    public static void main(String[] args) {
        add(5);
    }

    private static void add(int num) {
        Function<Integer, Integer> myAdder = x -> x + 10;
        Integer result = myAdder.apply(num);
        System.out.printf("%d + 10 = %d%n", num, result);
    }
}
