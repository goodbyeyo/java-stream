package com.study.javastream.stream;


import com.study.javastream.optional.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningByExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(29, 105, 209, 3029, 108, 7, 4096, 308);
        Map<Boolean, List<Integer>> numberPartitions = numbers.stream()
                .collect(Collectors.partitioningBy(number -> number % 2 == 0));
        System.out.println("짝수 = " + numberPartitions.get(true));
        System.out.println("홀수 = " + numberPartitions.get(false));

        Map<Boolean, List<User>> userPartitions = User.getUserList()
                .stream()
                .collect(Collectors.partitioningBy(user -> user.getFriendUserIds().size() > 3));

        EmailService emailService = new EmailService();
        userPartitions.get(true).forEach(emailService::sendPlayWithFriendsEmail);
        userPartitions.get(false).forEach(emailService::sendMakeMoreFriendsEmail);

    }
}
