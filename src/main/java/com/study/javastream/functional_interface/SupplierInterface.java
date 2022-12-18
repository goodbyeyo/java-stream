package com.study.javastream.functional_interface;

import java.util.function.Supplier;

public class SupplierInterface {
    public static void main(String[] args) {
        supplier();
        printRandomDoubles(Math::random, 5);
    }

    private static void supplier() {
        Supplier<String> myStringSupplier = () -> "nice to meet you";
        System.out.println("myStringSupplier = " + myStringSupplier.get());
    }

    public static void printRandomDoubles(Supplier<Double> randomSupplier, int count){
        for (int i =0 ; i < count; i++) {
            System.out.println(randomSupplier.get());
        }
    }
}
