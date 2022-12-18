package com.study.javastream.functional_interface;

import com.study.javastream.util.TriFunction;

public class TriFunctionInterface {

    public static void main(String[] args) {
        triFunction(10, 20, 30);
    }

    private static void triFunction(int num1, int num2, int num3) {
        TriFunction<Integer, Integer, Integer, Integer> addThreeNumbers = (x, y, z) -> x + y + z;
        Integer result = addThreeNumbers.apply(num1, num2, num3);
        System.out.printf("%d + %d + %d = %d%n", num1, num2, num3, result);
    }
}
