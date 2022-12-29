package com.study.javastream.applied_function;

import com.study.javastream.stream.model.Order;
import com.study.javastream.stream.model.OrderLine;

import java.math.BigDecimal;
import java.util.function.Function;

public class OrderLineAggregationPriceProcessor implements Function<Order, Order> {

    @Override
    public Order apply(Order order) {
        return Order.builder()
                .amount(order.getOrderLines().stream()
                        .map(OrderLine::getAmount)
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                        .build();
    }

}
