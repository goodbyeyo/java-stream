package com.study.javastream.stream;

import com.study.javastream.stream.model.Order;
import com.study.javastream.stream.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterExample {

    public static void main(String[] args) {

        Stream<Integer> number = Stream.of(1, -8, 9, -5, 10);
        Stream<Integer> filterNumber = number.filter(x -> x > 0);
        List<Integer> filteredNumbers = filterNumber.toList();
        System.out.println("filteredNumbers = " + filteredNumbers);

        // method chin
        List<Integer> integerList = Stream.of(1, -9, -19, 27, 39)
                .filter(x -> x > 0)
                .toList();
        System.out.println("integerList = " + integerList);

        List<User> users = User.getUserList();

        // 검증된 유저만 출력, isVerified : true
        List<User> verifiedList = users.stream()
                .filter(User::isVerified)
                .toList();
        System.out.println("verifiedList = " + verifiedList);

        // 검증되지 않은 유저만 출력, isVerified : false
        List<User> unVerifiedList = users.stream()
                .filter(user -> !user.isVerified())
                .toList();
        System.out.println("unVerifiedList = " + unVerifiedList);

        // 에러상태의 주문만 출력, status : ERROR
        List<Order> orders = Order.getOrderList();
        List<Order> errorOrderList = orders.stream()
                .filter(order -> order.getStatus().equals(Order.OrderStatus.ERROR))
                .toList();
        System.out.println("errorOrderList = " + errorOrderList);
    }
}
