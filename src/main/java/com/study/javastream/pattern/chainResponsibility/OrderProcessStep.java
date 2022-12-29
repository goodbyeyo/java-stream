package com.study.javastream.pattern.chainResponsibility;

import com.study.javastream.stream.model.Order;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * 책임 연쇄 패턴
 * - 행동 패턴의 하나
 * - 명령과 명령을 각각의 방법으로 처리할 수 있는 처리 객체들이 있을때 처리 객체들을 체인으로 엮는다
 * - 명령을 처리 객체들이 체인의 앞에서부터 하나씩 처리해보도록 한다
 * - 각 처리 객체는 자신이 처리 할 수 없을때 체인의 다음 처리 객체로 명령을 넘긴다
 * - 체인의 끝에 다다르면 처리가 끝난다
 * - 새로운 처리 객체를 추가하는 것으로 매우 간단히 처리 방법을 더 할 수 있다
 */
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
