package com.study.javastream.pattern.strategy;

import com.study.javastream.stream.model.User;

public class VerifyYourEmailAddressEmailProvider implements EmailProvider{
    @Override
    public String getEmail(User user) {
        return "Verify Your Email Address, Email for " + user.getName();
    }
}
