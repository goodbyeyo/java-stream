package com.study.javastream.applied_function;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LazyEvaluationEdited {

    public static void main(String[] args) {
//        if (returnTrue() || returnFalse()) {
//            System.out.println("true");
//        }
//
//        if (or(returnTrue(), returnFalse())) {
//            System.out.println("true");
//        }

//        if (lazyOr(() -> returnTrue(), () -> returnFalse())) {
//            System.out.println("true");
//        }

        Stream<Integer> integerStream = Stream.of(3, -2, 8, 19, 28, -7)
                .filter(x -> x > 0)
                .peek(x -> System.out.println("pekking " + x))
                .filter(x -> x % 2 == 0);
        System.out.println("Before Collect");

        List<Integer> integers = integerStream.collect(Collectors.toList());
        System.out.println("After Collect = " + integers);

    }

    private static boolean or(boolean x, boolean y) {
        return x || y;
    }

    private static boolean lazyOr(Supplier<Boolean> x, Supplier<Boolean> y) {
        return x.get() || y.get();
    }

    public static boolean returnTrue() {
        System.out.println("Returning true");
        return true;
    }

    public static boolean returnFalse() {
        System.out.println("Returning false");
        return false;
    }

}
