package com.study.javastream.applied_function;

import com.study.javastream.stream.model.Order;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class CompositionFunction {

    public static void main(String[] args) {
        Function<Integer, Integer> multiplyByTwo = x -> 2 * x;
        Function<Integer, Integer> addTen = x -> x + 10;

        Function<Integer, Integer> composedFunction = multiplyByTwo.andThen(addTen);
        System.out.println(composedFunction.apply(3));


        Order order = Order.getOrderList().get(0);
        List<Function<Order, Order>> priceProcessors = getPriceProcessors(order);
        Function<Order, Order> mergedPriceProcessors = priceProcessors.stream()
                .reduce(Function.identity(), Function::andThen);
        Order processedOrder = mergedPriceProcessors.apply(order);
        System.out.println("processedOrder = " + processedOrder);



//        priceProcessors.stream()
//                .reduce(Function.identity(), Function::andThen);

//                .reduce(Function.identity(), (priceProcessors1, priceProcessors2) ->
//                        priceProcessors1.andThen(priceProcessors2));

    }

    public static List<Function<Order, Order>> getPriceProcessors(Order order) {
        return Arrays.asList(new OrderLineAggregationPriceProcessor(),
                new TaxPriceProcessor(new BigDecimal("5.137")));
    }
}
