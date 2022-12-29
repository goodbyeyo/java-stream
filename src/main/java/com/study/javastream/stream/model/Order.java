package com.study.javastream.stream.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Builder
@Getter
@ToString
public class Order {
    private long id;
    private LocalDateTime createAt;
    private long createdByUserId;
    private OrderStatus status;
    private BigDecimal amount;
    private List<OrderLine> orderLines;

    public enum OrderStatus {
        CREATED,
        IN_PROGRESS,
        ERROR,
        PROCESSED
    }

    public static List<Order> getOrderList() {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        Order order1 = Order.builder()
                .id(1)
                .status(Order.OrderStatus.CREATED)
                .createdByUserId(1)
                .createAt(now.minusHours(4))
                .amount(BigDecimal.valueOf(50000))
                .orderLines(Arrays.asList(
                        OrderLine.builder()
                                .id(1001)
                                .type(OrderLine.OrderLineType.PURCHASE)
                                .amount(BigDecimal.valueOf(60_000L))
                                .build(),
                        OrderLine.builder()
                                .id(1002)
                                .type(OrderLine.OrderLineType.PURCHASE)
                                .amount(BigDecimal.valueOf(40_000L))
                                .build()))
                .build();

        Order order2 = Order.builder().id(2)
                .status(Order.OrderStatus.ERROR)
                .createdByUserId(2)
                .createAt(now.minusHours(1))
                .amount(BigDecimal.valueOf(70000))
                .orderLines(Arrays.asList(
                        OrderLine.builder()
                                .id(1001)
                                .type(OrderLine.OrderLineType.PURCHASE)
                                .amount(BigDecimal.valueOf(70_000L))
                                .build(),
                        OrderLine.builder()
                                .id(1002)
                                .type(OrderLine.OrderLineType.DISCOUNT)
                                .amount(BigDecimal.valueOf(-10_000L))
                                .build()))
                .build();

        Order order3 = Order.builder().id(3)
                .status(Order.OrderStatus.IN_PROGRESS)
                .createdByUserId(3)
                .createAt(now.minusHours(9))
                .amount(BigDecimal.valueOf(90000))
                .orderLines(Collections.singletonList(OrderLine.builder()
                        .id(1001)
                        .type(OrderLine.OrderLineType.PURCHASE)
                        .amount(BigDecimal.valueOf(90_000L))
                        .build()))
                .build();

        Order order4 = Order.builder().id(4)
                .status(Order.OrderStatus.PROCESSED)
                .createdByUserId(2)
                .createAt(now.minusHours(24))
                .amount(BigDecimal.valueOf(10000))
                .orderLines(Arrays.asList(
                        OrderLine.builder()
                                .id(1001)
                                .type(OrderLine.OrderLineType.PURCHASE)
                                .amount(BigDecimal.valueOf(10_000L))
                                .build(),
                        OrderLine.builder()
                                .id(1002)
                                .type(OrderLine.OrderLineType.DISCOUNT)
                                .amount(BigDecimal.valueOf(-2_000L))
                                .build()))
                .build();

        Order order5 = Order.builder().id(5)
                .status(Order.OrderStatus.ERROR)
                .createdByUserId(3)
                .createAt(now.minusHours(72))
                .amount(BigDecimal.valueOf(200000))
                .orderLines(Arrays.asList(
                        OrderLine.builder()
                                .id(1001)
                                .type(OrderLine.OrderLineType.PURCHASE)
                                .amount(BigDecimal.valueOf(200_000L))
                                .build(),
                        OrderLine.builder()
                                .id(1002)
                                .type(OrderLine.OrderLineType.DISCOUNT)
                                .amount(BigDecimal.valueOf(-30_000L))
                                .build()))
                .build();

        return Arrays.asList(order1, order2, order3, order4, order5);
    }
}
