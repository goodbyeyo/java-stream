package com.study.javastream.functional_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Filter {

    public static void main(String[] args) {
        Predicate<Integer> isPositive = x -> x > 0;
        List<Integer> inputs = Arrays.asList(50, -10, 3, -25, 0);

        // 해당 조건을 만족하는 값만 출력 : 양수만 출력
        System.out.println("Positive number" + filter(inputs, isPositive));

        // 해당 조건을 만족하지 않는 값 출력 : 양수가 아닌 값들만 출력
        System.out.println("Non Positive number" + filter(inputs, isPositive.negate()));

        // 해당 조건도 만족하는 값 출력 : 양수중에서 0도 포함해서 출력
        System.out.println("Positive number and Zero" + filter(inputs, isPositive.or((x -> x == 0))));

        // 해당 조건을 만족하는 값 출력 : 양수중에서 짝수만 출력
        System.out.println("Positive even number " + filter(inputs, isPositive.and((x -> x%2 == 0))));
    }

    public static <T> List<T> filter(List<T> inputs, Predicate<T> condition) {
        List<T> output = new ArrayList<>();
        for ( T input : inputs ) {
            if (condition.test(input)) {
                output.add(input);
            }
        }
        return output;
    }
}

