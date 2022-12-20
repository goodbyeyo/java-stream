package com.study.javastream.method_reference;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * ClassName::StaticMethodName
 */
public class StaticMethod {

    public static void main(String[] args) {
        Function<String, Integer> strToInt = Integer::parseInt;
        System.out.println(strToInt.apply("500"));

        String str = "goodbye";
        Predicate<String> equalsToString = str::equals;
        System.out.println(equalsToString.test("goodbye"));
        System.out.println(equalsToString.test("bye"));

        System.out.println(calculate(9, 3, StaticMethod::multiply));

        StaticMethod instance = new StaticMethod();
        System.out.println(calculate(9, 3, instance::subtract));

    }

    public void myMethod() {
        System.out.println(calculate(9, 3, this::subtract));
    }

    public int subtract(int x, int y) {
        return x - y;
    }

    public static int calculate(int x, int y, BiFunction<Integer, Integer, Integer> operator) {
        return operator.apply(x, y);
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

}
