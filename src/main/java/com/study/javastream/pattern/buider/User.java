package com.study.javastream.pattern.buider;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class User {

    private int id;
    private String name;
    private String emailAddress;
    private boolean isVerified;
    private LocalDateTime createAt;
    private List<Integer> friendUserIds = new ArrayList<>();

    public User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.emailAddress = builder.emailAddress;
        this.isVerified = builder.isVerified;
        this.createAt = builder.createAt;
        this.friendUserIds = builder.friendUserIds;
    }

    public static Builder builder(int id, String name) {
        return new Builder(id, name);
    }

    public static class Builder {
        private int id;
        private String name;
        private String emailAddress;
        private boolean isVerified;
        private LocalDateTime createAt;
        private List<Integer> friendUserIds = new ArrayList<>();

        private Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder withEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder withVerified(boolean isVerified) {
            this.isVerified = isVerified;
            return this;
        }

        public Builder withCreateAt(LocalDateTime createAt) {
            this.createAt = createAt;
            return this;
        }

        public Builder withFriendUserIds(List<Integer> friendUserIds) {
            this.friendUserIds = friendUserIds;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
