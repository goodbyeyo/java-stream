package com.study.javastream.stream;

import com.study.javastream.stream.model.Order;
import java.util.Arrays;
import java.util.List;

public class DistinctExample {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 3, 4, 4, 4, 5);
        List<Integer> result = integerList.stream()
                .distinct()
                .toList();
        System.out.println("result = " + result);

        // created a sorted list of unique CreatedByUserIds
        List<Long> orderList = Order.getOrderList().stream()
                .map(Order::getCreatedByUserId)
                .distinct()
                .sorted()
                .toList();
        System.out.println("orderList = " + orderList);
    }
}
