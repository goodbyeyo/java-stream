package com.study.javastream.applied_function;

import com.study.javastream.stream.model.Order;

import java.math.BigDecimal;
import java.util.function.Function;

public class TaxPriceProcessor implements Function<Order, Order> {

    private final BigDecimal taxRate;

    public TaxPriceProcessor(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public Order apply(Order order) {
        return Order.builder()
                .amount(order.getAmount()
                        .multiply(taxRate.divide(new BigDecimal(100)).add(BigDecimal.ONE)))
                .build();
    }
}
