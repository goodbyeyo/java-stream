package com.study.javastream.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {

        Stream<String> city = Stream.of("Seoul, Pusan", "Inchon");
        List<String> cityList = city.collect(Collectors.toList());
        System.out.println("cityList = " + cityList);

        String[] cityArray = new String[]{"Seoul, Pusan", "Inchon"};
        // ciryArray -> Stream 형태로 변경되어서 어사인?
        Stream<String> cityStream = Arrays.stream(cityArray);
        List<String> cityArrayList = cityStream.collect(Collectors.toList());
        System.out.println("cityArrayList = " + cityArrayList);

        // Set -> Java Collection -> Stream
        Set<Integer> numberSet = new HashSet<>(Arrays.asList(8, 3, 6));
        List<Integer> numberList = numberSet.stream().collect(Collectors.toList());
        System.out.println("numberList = " + numberList);


    }
}
