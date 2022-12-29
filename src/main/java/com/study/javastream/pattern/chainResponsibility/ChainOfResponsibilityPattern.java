package com.study.javastream.pattern.chainResponsibility;

import com.study.javastream.stream.model.Order;
import com.study.javastream.stream.model.OrderLine;

import java.math.BigDecimal;

public class ChainOfResponsibilityPattern {

    public static void main(String[] args) {
        OrderProcessStep initiallizeStep = new OrderProcessStep(order -> {
            if (order.getStatus() == Order.OrderStatus.CREATED) {
                System.out.println("Start Processing Order " + order.getId());
                Order.builder()
                        .id(order.getId())
                        .amount(order.getAmount())
                        .createAt(order.getCreateAt())
                        .status(Order.OrderStatus.IN_PROGRESS)
                        .build();
            }
        });

        OrderProcessStep setOrderAmountStep = new OrderProcessStep(order -> {
            if (order.getStatus() == Order.OrderStatus.IN_PROGRESS) {
                System.out.println("Setting Amount Of Order " + order.getAmount());
                Order.builder()
                        .id(order.getId())
                        .amount(order.getOrderLines().stream()
                                .map(OrderLine::getAmount)
                                .reduce(BigDecimal.ZERO, BigDecimal::add));
            }
        });

        OrderProcessStep verifyOrderStep = new OrderProcessStep(order -> {
            if (order.getStatus() == Order.OrderStatus.IN_PROGRESS) {
                System.out.println("Verifying Order " + order.getId());
                if (order.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
                    Order.builder()
                            .status(Order.OrderStatus.ERROR)
                            .build();
                }
            }
        });

        OrderProcessStep processPaymentStep = new OrderProcessStep(order -> {
            if (order.getStatus() == Order.OrderStatus.IN_PROGRESS) {
                System.out.println("Processing Payment Of Order " + order.getId());
                Order.builder()
                        .status(Order.OrderStatus.PROCESSED)
                        .build();
            }
        });

        OrderProcessStep handleErrorStep = new OrderProcessStep(order -> {
            if (order.getStatus() == Order.OrderStatus.ERROR) {
                System.out.println("Sending out Failed To Process Order Alert For Order " + order.getId());
            }
        });

        OrderProcessStep completeProcessingOrderStep = new OrderProcessStep(order -> {
            if (order.getStatus() == Order.OrderStatus.PROCESSED) {
                System.out.println("Finished Processing Order " + order.getId());
            }
        });

        OrderProcessStep chainedOrderProcessStep = initiallizeStep
                .setNext(setOrderAmountStep)
                .setNext(verifyOrderStep)
                .setNext(processPaymentStep)
                .setNext(handleErrorStep)
                .setNext(completeProcessingOrderStep);

        Order order = Order.getOrderList().get(0);

        chainedOrderProcessStep.process(order);

    }
}
