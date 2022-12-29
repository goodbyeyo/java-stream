package com.study.javastream.pattern.buider;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Getter
@ToString
public class UserComsumer {

    private int id;
    private String name;
    private String emailAddress;
    private boolean isVerified;
    private LocalDateTime createAt;
    private List<Integer> friendUserIds = new ArrayList<>();

    public UserComsumer(Builder builder) {
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
        public String emailAddress;
        public boolean isVerified;
        public LocalDateTime createAt;
        public List<Integer> friendUserIds = new ArrayList<>();

        private Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder with(Consumer<Builder> consumer) {
            consumer.accept(this);
            return this;
        }

        public UserComsumer build() {
            return new UserComsumer(this);
        }
    }
}
