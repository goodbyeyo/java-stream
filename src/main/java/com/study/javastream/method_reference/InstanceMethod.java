package com.study.javastream.method_reference;

import com.study.javastream.functional_interface.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * ClassName::instanceMethodName
 */
public class InstanceMethod {

    public static void main(String[] args) {
        Function<String, Integer> strLength = String::length;
        Integer length = strLength.apply("nice to meet you");
        System.out.println("length = " + length);

        BiPredicate<String, String> strEquals = String::equals;
        boolean isEquals = strEquals.test("Seoul", "Seoul");
        System.out.println("isEquals = " + isEquals);

        List<User> users = new ArrayList<User>();
        users.add(new User(3, "Hero"));
        users.add(new User(1, "Jim"));
        users.add(new User(7, "Alice"));

        printUserField(users, User::getId); // printUserField(users, (User user) -> user.getId());
    }

    public static void printUserField(List<User> uses, Function<User, Object> getter) {
        for (User user : uses) {
            System.out.println(getter.apply(user));
        }
    }
}
