package com.study.javastream;

import com.study.javastream.util.TriFunction;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class App {

    public static void main(String[] args) {
        add(5);
        multiply(5, 10);
        triFunction(10, 20, 30);
        supplier();
        printRandomDoubles(Math::random, 5);
        consumer();
        process(Arrays.asList(1, 2, 3),
                x -> System.out.println("Processing Integer = " + x));
        process(Arrays.asList(1.2, 2.4, 3.6),
                x -> System.out.println("Processing Double = " + x));
    }

    public static <T> void process(List<T> inputs, Consumer<T> processor) {
        for (T input : inputs) {
            processor.accept(input);
        }
    }

    private static void consumer() {
        Consumer<String> consumer = (String str) -> {
            System.out.println("str = " + str);
        };
        consumer.accept("consumer method");
    }

    public static void printRandomDoubles(Supplier<Double> randomSupplier, int count){
        for (int i =0 ; i < count; i++) {
            System.out.println(randomSupplier.get());
        }
    }

    private static void supplier() {
        Supplier<String> myStringSupplier = () -> "nice to meet you";
        System.out.println("myStringSupplier = " + myStringSupplier.get());
    }


    private static void triFunction(int num1, int num2, int num3) {
        TriFunction<Integer, Integer, Integer, Integer> addThreeNumbers = (x, y, z) -> x + y + z;
        Integer result = addThreeNumbers.apply(num1, num2, num3);
        System.out.printf("%d + %d + %d = %d%n", num1, num2, num3, result);
    }

    private static void add(int num) {
        Function<Integer, Integer> myAdder = x -> x + 10;
        Integer result = myAdder.apply(num);
        System.out.printf("%d + 10 = %d%n", num, result);
    }

    private static void multiply(int num1, int num2) {
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x * y;
        Integer result = add.apply(num1, num2);
        System.out.printf("%d * %d = %d%n", num1, num2, result);
    }
}
