package com.study.javastream.optional;

import lombok.Builder;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Builder
@ToString
public class User {
    private int id;
    private String name;
    private String emailAddress;
    private boolean isVerified;
    private List<Integer> friendUserIds;
    private LocalDateTime createAt;

    public static List<User> getUserList() {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        User user1 = User.builder()
                .id(1)
                .name("Mary")
                .isVerified(true)
                .emailAddress("mary@naver.com")
                .createAt(now.minusDays(2))
                .friendUserIds(Arrays.asList(101, 102, 103, 104))
                .build();
        User user2 = User.builder()
                .id(2)
                .name("Yen")
                .isVerified(false)
                .emailAddress("hero@naver.com")
                .createAt(now.minusHours(10))
                .friendUserIds(Arrays.asList(104, 105, 106))
                .build();
        User user3 = User.builder()
                .id(3)
                .name("Apple")
                .isVerified(false)
                .emailAddress("poul@naver.com")
                .createAt(now.minusDays(7))
                .friendUserIds(Arrays.asList(104, 105, 106))
                .build();
        User user4 = User.builder()
                .id(4)
                .name("Yarn")
                .isVerified(false)
                .emailAddress("yarn@naver.com")
                .createAt(now.minusHours(17))
                .friendUserIds(Arrays.asList(106, 107))
                .build();
        return Arrays.asList(user1, user2, user3, user4);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmailAddress() {
        return Optional.ofNullable(emailAddress);
    }

    public boolean isVerified() {
        return isVerified;
    }

    public List<Integer> getFriendUserIds() {
        return friendUserIds;
    }
}
