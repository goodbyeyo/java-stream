package com.study.javastream.stream;

import com.study.javastream.stream.model.Order;
import com.study.javastream.stream.model.User;

import java.util.Arrays;
import java.util.List;

public class MatchExample {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(4, 9, 0, -2, -7);
        boolean allPositive = integerList.stream()
                .allMatch(number -> number > 0);
        System.out.println("Are all numbers postive: " + allPositive);

        boolean anyNegative = integerList.stream()
                .anyMatch(number -> number < 0);
        System.out.println("Is any number negative: " + anyNegative);

        boolean areAllUserVerified = User.getUserList().stream()
                .allMatch(User::isVerified);
        System.out.println("Are all user verifiable: " + areAllUserVerified);

        boolean anyMatchError = Order.getOrderList().stream()
                .anyMatch(order -> order.getStatus() == Order.OrderStatus.ERROR);
        System.out.println("is any match error: " + anyMatchError);
    }
}
