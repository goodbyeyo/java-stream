package com.study.javastream.stream;

import com.study.javastream.stream.model.Order;
import com.study.javastream.stream.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapExample {

    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(8, 2, -7);
        Stream<Integer> numberStream = numberList.stream();

        List<Integer> integerList = numberStream.map(x -> x * 2).toList();
        System.out.println("integerList = " + integerList);

        List<User> users = User.getUserList();
        List<String> emailList = users.stream()
                .map(User::getEmailAddress)
                .toList();
        System.out.println("emailList = " + emailList);

        List<Order> orders = Order.getOrderList();
        List<Long> userIdList = orders.stream()
                .map(Order::getCreatedByUserId)
                .distinct()
                .toList();
        System.out.println("userIdList = " + userIdList);


    }



}
