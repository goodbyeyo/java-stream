package com.study.javastream.stream;

import com.study.javastream.stream.model.Order;
import com.study.javastream.stream.model.User;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateOperation {

    public static void main(String[] args) {
        List<String> resultList = User.getUserList().stream()
                .filter(user -> !user.isVerified())
                .map(User::getEmailAddress)
                .toList();
        System.out.println("resultList = " + resultList);

        List<Long> orderList = Order.getOrderList().stream()
                .filter(order -> order.getStatus().equals(Order.OrderStatus.ERROR))
                .map(Order::getId)
                .toList();
        System.out.println("orderList = " + orderList);

        // Error 상태의 오더중에서 24시간이내에 생성된 주문정보만 출력
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        List<Order> orders = Order.getOrderList().stream()
                .filter(order -> order.getStatus().equals(Order.OrderStatus.ERROR))
                .filter(order -> order.getCreateAt().isAfter(now.minusHours(24))).toList();
        System.out.println("orders = " + orders);

    }
}
