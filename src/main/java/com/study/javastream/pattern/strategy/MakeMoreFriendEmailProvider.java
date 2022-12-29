package com.study.javastream.pattern.strategy;

import com.study.javastream.stream.model.User;

public class MakeMoreFriendEmailProvider implements EmailProvider {

    @Override
    public String getEmail(User user) {
        return "Make More Friend Email For " + user.getName();
    }
}
