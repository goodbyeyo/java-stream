package com.study.javastream.pattern.chainResponsibility;

import com.study.javastream.stream.model.Order;

import java.util.Optional;
import java.util.function.Consumer;

public class OrderProcessStep {
    private final Consumer<Order> proessOrder;
    private OrderProcessStep next;

    public OrderProcessStep(Consumer<Order> proessOrder) {
        this.proessOrder = proessOrder;
    }

    public OrderProcessStep setNext(OrderProcessStep next) {
        if (this.next == null) {
            this.next = next;
        } else {
            this.next.setNext(next);
        }
        return this;
    }

    public void process(Order order) {
        proessOrder.accept(order);
        Optional.ofNullable(next)
                .ifPresent(nextStep -> nextStep.process(order));
    }
}
