package com.study.javastream.stream.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@Builder
@Getter
@ToString
public class User {
    private int id;
    private String name;
    private String emailAddress;
    private boolean isVerified;
    private List<Integer> friendUserIds;

    public static List<User> getUserList() {
        User user1 = User.builder()
                .id(1)
                .name("Mary")
                .isVerified(true)
                .emailAddress("mary@naver.com").build();
        User user2 = User.builder()
                .id(2).
                name("Yen")
                .isVerified(false)
                .emailAddress("hero@naver.com").build();
        User user3 = User.builder().
                id(3).
                name("Apple")
                .isVerified(false)
                .emailAddress("poul@naver.com").build();
        return Arrays.asList(user1, user2, user3);
    }
}

