package com.study.javastream.stream;

import com.study.javastream.stream.model.Order;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class GroupingByExampleTest {

    @Test
    void groupByTest() {
        Map<Order.OrderStatus, List<Order>> orderStatusListMap = Order.getOrderList()
                .stream()
                .collect(Collectors.groupingBy(Order::getStatus));
        assertEquals(1L,
                orderStatusListMap.get(Order.OrderStatus.CREATED).get(0).getId());
        assertEquals(BigDecimal.valueOf(50000),
                orderStatusListMap.get(Order.OrderStatus.CREATED).get(0).getAmount());


    }

}