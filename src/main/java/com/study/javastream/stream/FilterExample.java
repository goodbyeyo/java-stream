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
        List<Integer> filteredNumbers = filterNumber.collect(Collectors.toList());
        System.out.println("filteredNumbers = " + filteredNumbers);

        // method chin
        List<Integer> integerList = Stream.of(1, -9, -19, 27, 39)
                .filter(x -> x > 0)
                .toList();
        System.out.println("integerList = " + integerList);

        User user1 = User.builder().id(1).name("Mary").isVerified(true).emailAddress("mary@naver.com").build();
        User user2 = User.builder().id(2).name("Hero").isVerified(false).emailAddress("hero@naver.com").build();
        User user3 = User.builder().id(3).name("Poul").isVerified(false).emailAddress("poul@naver.com").build();
        List<User> users = Arrays.asList(user1, user2, user3);

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

        Order order1 = Order.builder().id(1).status(Order.OrderStatus.CREATED).build();
        Order order2 = Order.builder().id(2).status(Order.OrderStatus.ERROR).build();
        Order order3 = Order.builder().id(3).status(Order.OrderStatus.IN_PROGRESS).build();
        Order order4 = Order.builder().id(4).status(Order.OrderStatus.PROCESSED).build();
        Order order5 = Order.builder().id(5).status(Order.OrderStatus.ERROR).build();
        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);

        // 에러상태의 주문만 출력, status : ERROR
        List<Order> errorOrderList = orders.stream()
                .filter(order -> order.getStatus().equals(Order.OrderStatus.ERROR))
                .toList();
        System.out.println("errorOrderList = " + errorOrderList);

    }
}
