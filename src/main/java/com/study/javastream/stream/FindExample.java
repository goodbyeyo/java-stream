package com.study.javastream.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class FindExample {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(4, -9, -3, -7, 0);

        Optional<Integer> anyNegativeInteger = integerList.stream()
                .filter(x -> x < 0)
                .findAny();
        System.out.println("anyNegativeInteger = " + anyNegativeInteger);

        Optional<Integer> firstPositiveInteger = integerList.stream()
                .filter(x -> x > 0)
                .findFirst();
        System.out.println("firstPositiveInteger = " + firstPositiveInteger);

    }
}
