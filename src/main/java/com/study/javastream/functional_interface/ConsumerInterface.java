package com.study.javastream.functional_interface;

import java.util.Arrays;
import java.util.List;

public class ConsumerInterface {

    public static void main(String[] args) {
        consumer();

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        process(integerList, x -> System.out.println("Processing Integer = " + x));

        List<Double> doubleList = Arrays.asList(1.2, 2.4, 3.6);
        process(doubleList, x -> System.out.println("Processing Double = " + x));
    }


    public static <T> void process(List<T> inputs, java.util.function.Consumer<T> processor) {
        for (T input : inputs) {
            processor.accept(input);
        }
    }

    private static void consumer() {
        java.util.function.Consumer<String> consumer = (String str) -> {
            System.out.println("str = " + str);
        };
        consumer.accept("consumer method");
    }
}

