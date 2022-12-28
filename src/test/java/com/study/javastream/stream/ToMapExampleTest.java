package com.study.javastream.stream;

import com.study.javastream.stream.model.Order;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ToMapExampleTest {

    @Test
    void toMapTest() {
        Map<Long, Order.OrderStatus> orderStatusMap = Order.getOrderList()
                .stream()
                .collect(Collectors.toMap(Order::getId, Order::getStatus));
        assertEquals(Order.OrderStatus.CREATED, orderStatusMap.get(1L));
    }

}