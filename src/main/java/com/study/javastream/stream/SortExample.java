package com.study.javastream.stream;

import com.study.javastream.stream.model.Order;
import com.study.javastream.stream.model.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortExample {

    public static void main(String[] args) {

        // sort numbers
        List<Integer> integerList = Arrays.asList(9, -1, 6, 2);
        List<Integer> sortedList = integerList.stream()
                .sorted()
                .toList();
        System.out.println("sortedList = " + sortedList);

        // sort the users based on name
        List<User> userList = User.getUserList();
        List<User> sortedUserList = userList.stream()
                .sorted(Comparator.comparing(User::getName))
                //.sorted((u1, u2) -> u1.getName().compareTo(u2.getName()))
                .toList();
        System.out.println("sortedUserList = " + sortedUserList);

        // sort the orders based on createAt
        List<Order> sortedOrdersList = Order.getOrderList().stream()
                .sorted(Comparator.comparing(Order::getCreateAt))
                //.sorted((o1, o2) -> o1.getCreateAt().compareTo(o2.getCreateAt()))
                .toList();
        System.out.println("sortedOrdersList = " + sortedOrdersList);
    }
}
