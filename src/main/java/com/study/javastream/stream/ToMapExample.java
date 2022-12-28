package com.study.javastream.stream;

import com.study.javastream.stream.model.Order;
import com.study.javastream.stream.model.User;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToMapExample {

    public static void main(String[] args) {
        Map<Integer, String> numberMap = Stream.of(2, 9, 7, -3, -7)
                .collect(Collectors.toMap(Function.identity(), x -> "Number is " + x));
        System.out.println(numberMap.get(9));

        // 유저리스트를 아아디를 key 로 User 전체를 value 로
        Map<Integer, User> userIdToUserMap = User.getUserList()
                .stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));
        System.out.println(userIdToUserMap.get(1));

        // 오더리스트의 아이디를 key 로 status 를 value 로
        Map<Long, Order.OrderStatus> orderStatusMap = Order.getOrderList().stream()
                .collect(Collectors.toMap(Order::getId, Order::getStatus));


    }
}
