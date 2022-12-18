package com.study.javastream.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerInterface {
    public static void main(String[] args) {
        BiConsumer<Integer, Double> myDoubleProcessor = (index, input) ->
                System.out.println("Processing " + input + " at index " + index);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3, 4.4);
        process(doubleList, myDoubleProcessor);
    }



    public static <T> void process(List<T> input, BiConsumer<Integer, T> processor) {
        for (int i=0; i<input.size(); i++) {
            processor.accept(i, input.get(i));
        }
    }
}
