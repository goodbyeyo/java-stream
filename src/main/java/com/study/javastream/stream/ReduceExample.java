package com.study.javastream.stream;

import com.study.javastream.stream.model.Order;
import com.study.javastream.stream.model.OrderLine;
import com.study.javastream.stream.model.User;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ReduceExample {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(7, -1, 2, -3);

        Integer sum = integerList.stream()
                .reduce(Integer::sum)
                .get();

        Integer min = integerList.stream()
                .reduce((x, y) -> x < y ? x : y)
                .get();
        System.out.println("min = " + min);

        Integer product = integerList.stream()
                .reduce(1, (x, y) -> x * y);
        System.out.println("product = " + product);

        List<String> stringList = Arrays.asList("4", "3", "-8", "6");
        Integer sumOfNumberStrList = stringList.stream()
                .map(Integer::parseInt)
                .reduce(0, (x, y) -> x + y);
        System.out.println("sumOfNumberStrList = " + sumOfNumberStrList);

        Integer sumOfNumberStrList2 = stringList.stream()
                .reduce(0, (number, str) ->
                        number + Integer.parseInt(str), Integer::sum);
        System.out.println("sumOfNumberStrList2 = " + sumOfNumberStrList2);

        // 유저리스트의 친구목록의 합을 출력
        Integer sumOfNumberOfFriends = User.getUserList().stream()
                .map(User::getFriendUserIds)
                .map(List::size)
                .reduce(0, Integer::sum);  // .reduce(0, (x, y) -> x + y);
        System.out.println(sumOfNumberOfFriends);

        // 오더리스트의 amount 합을 출력
        BigDecimal sumOfAmounts = Order.getOrderList()
                .stream()
                .map(Order::getOrderLines)
                .flatMap(List::stream)
                .map(OrderLine::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("sumOfAmounts = " + sumOfAmounts);


    }
}
