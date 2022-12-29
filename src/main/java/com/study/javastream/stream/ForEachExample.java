package com.study.javastream.stream;

import com.study.javastream.optional.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ForEachExample {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(9, 18, 27, 36, 45, 54);
        integerList.forEach(number -> System.out.println("The number is " + number));

        EmailService emailService = new EmailService();
        List<User> userList = User.getUserList();

        userList.stream()
                .filter(user -> !user.isVerified())
                .forEach(emailService::sendVerifyEmail);

        IntStream.range(0, userList.size())
                .forEach(i -> System.out.println("Do an operation on user " +
                        userList.get(i).getName() + " at index " + i));
    }
}
