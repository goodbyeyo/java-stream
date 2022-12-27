package com.study.javastream.stream;

import com.study.javastream.stream.model.Order;
import com.study.javastream.stream.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MinMaxCountExample {

    public static void main(String[] args) {
        Optional<Integer> max = Stream.of(2, 9, 3, -4, -8, 0)
                .max(Integer::compareTo);
        System.out.println("max = " + max);

        List<User> userList = User.getUserList();
        User firstUser = userList.stream()
                .min(Comparator.comparing(User::getName))
                .get();
        System.out.println("firstUser = " + firstUser);

        long positiveIntegerCount = Stream.of(7, -2, -9, 0, 8)
                .filter(x -> x > 0)
                .count();
        System.out.println("positiveIntegerCount = " + positiveIntegerCount);

        // 최근 24시간 이내 가입한 유저중 검증되지 않은 유저의 수
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        long count = userList.stream()
                .filter(user -> user.getCreateAt().isAfter(now.minusDays(1)))
                .filter(user -> !user.isVerified())
                .count();
        System.out.println("count = " + count);

        // 에러상태의 오더중 AMOUNT 가장 작은 오더
        Order orderList = Order.getOrderList()
                .stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .min(Comparator.comparing(Order::getAmount))
                .get();
        System.out.println("orderList = " + orderList);

        // 에러상태의 오더중 가장 큰 AMOUNT 만 출력
        BigDecimal maxAmount = Order.getOrderList()
                .stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .map(Order::getAmount)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);   // optional data null 일때 default 처리
        System.out.println("maxAmount = " + maxAmount);


    }


}
