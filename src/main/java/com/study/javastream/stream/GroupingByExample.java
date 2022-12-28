package com.study.javastream.stream;

import com.study.javastream.stream.model.Order;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByExample {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(15, 203, 209, 304, 408, 603, 102);

        Map<Integer, List<String>> unitDigitStrMap = integerList.stream()
                .collect(Collectors.groupingBy(number -> number % 10,
                        Collectors.mapping(number -> "unit digit is " + number,
                                Collectors.toList())));
        System.out.println(unitDigitStrMap.get(3));

        Map<Order.OrderStatus, List<Order>> orderStatusListMap = Order.getOrderList()
                .stream()
                .collect(Collectors.groupingBy(Order::getStatus));
        System.out.println("orderStatusListMap = " + orderStatusListMap.get(Order.OrderStatus.CREATED).get(0).getId());

        Map<Order.OrderStatus, BigDecimal> amountSumMap = Order.getOrderList()
                .stream()
                .collect(Collectors.groupingBy(Order::getStatus,
                        Collectors.mapping(Order::getAmount,
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));

        System.out.println("amountSumMap = " + amountSumMap);

    }
}
