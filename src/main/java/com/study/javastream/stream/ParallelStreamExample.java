package com.study.javastream.stream;

import com.study.javastream.optional.User;

import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamExample {

    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
//        EmailService emailService = new EmailService();
//        User.getUserList().stream()
//                .filter(user -> !user.isVerified())
//                .forEach(emailService::sendVerifyEmail);
//        long endTime = System.currentTimeMillis();
//        System.out.println("Sequential = " + (endTime - startTime) + " ms");
//
//        startTime = System.currentTimeMillis();
//        User.getUserList().stream().parallel()
//                .filter(user -> !user.isVerified())
//                .forEach(emailService::sendVerifyEmail);
//        endTime = System.currentTimeMillis();
//        System.out.println("Sequential = " + (endTime - startTime) + " ms");

        List<User> processedUser = User.getUserList().parallelStream()
                .map(user -> {
                    System.out.println("Capitalize user name for user " + user.getId());
                    return User.builder()
                            .name(user.getName().toUpperCase())
                            .build();
                })
                .map(user -> {
                    System.out.println("Set 'isVerified' to true for user " + user.getId());
                    return User.builder()
                            .isVerified(true)
                            .build();
                }).toList();
        System.out.println("processedUser = " + processedUser);
    }
}
