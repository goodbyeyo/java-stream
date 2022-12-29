package com.study.javastream.applied_function;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class CurryExample {
    public static void main(String[] args) {
        Supplier<String> supplier = getStringSupplier();
        System.out.println(supplier.get());

        BiFunction<Integer, Integer, Integer> add = Integer::sum; // (x, y) -> x + y;
        Function<Integer, Function<Integer, Integer>> curriedAdd = x -> y -> x + y;

        Function<Integer, Integer> addThree = curriedAdd.apply(3);
        Integer result = addThree.apply(10);

        System.out.println(result);

    }

    public static Supplier<String> getStringSupplier() {
        String str = "Hello";
        Supplier<String> supplier = () -> {
            String str2 = "World";
            return str + str2;
        };
        return supplier;
    }
}
