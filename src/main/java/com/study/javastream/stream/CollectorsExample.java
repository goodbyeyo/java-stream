package com.study.javastream.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsExample {

    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(2, 9, 7, 4, -5, 2);

        List<Integer> integerList = numberList.stream()
                .collect(Collectors.toList());
        System.out.println("integerList = " + integerList);

        Set<Integer> integerSet = numberList.stream()
                .collect(Collectors.toSet());
        System.out.println("integerSet = " + integerSet);

        List<Integer> integers = numberList.stream()
                .collect(Collectors.mapping(x -> Math.abs(x), Collectors.toList()));
        System.out.println("integers = " + integers);

        Set<Integer> integerSet1 = numberList.stream()
                .collect(Collectors.mapping(x -> Math.abs(x), Collectors.toSet()));
        System.out.println("integerSet1 = " + integerSet1);

        Integer sum = numberList.stream()
                .collect(Collectors.reducing(0, (x, y) -> x + y));
        System.out.println("sum = " + sum);


    }
}

