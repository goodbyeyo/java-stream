package com.study.javastream.stream;

import com.study.javastream.stream.model.Order;
import com.study.javastream.stream.model.OrderLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMapExample {

    public static void main(String[] args) {

        String[][] cities = new String[][] {
                { "Seoul", "Inchon" },
                { "New York", "Los Angeles" },
                { "Paris", "London" }
        };
        List<Stream<String>> streamList = Arrays.stream(cities)
                .map(Arrays::stream)
                .toList();
        System.out.println("streamList = " + streamList);

        List<String> result = Arrays.stream(cities)
                .flatMap(Arrays::stream).toList();
        System.out.println("result = " + result);


        List<Order> orderList = Order.getOrderList();
        List<Stream<OrderLine>> resultList = orderList.stream()
                .map(Order::getOrderLines)
                .map(List::stream).toList();
        System.out.println("resultList = " + resultList);

        List<OrderLine> orderLineList = orderList.stream()
                .map(Order::getOrderLines)
                .flatMap(List::stream).toList();
        System.out.println("orderLineList = " + orderLineList);
    }
}
