package com.study.javastream.pattern.strategy;

import com.study.javastream.stream.model.User;

public interface EmailProvider {
    String getEmail(User user);
}
