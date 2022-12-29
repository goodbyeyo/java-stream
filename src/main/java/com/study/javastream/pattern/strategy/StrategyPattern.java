package com.study.javastream.pattern.strategy;

import com.study.javastream.stream.model.User;

import java.util.List;

public class StrategyPattern {

    public static void main(String[] args) {
        List<User> userList = User.getUserList();
        EmailSender emailSender = new EmailSender();
        EmailProvider verifyYourEmailAddressEmailProvider = new VerifyYourEmailAddressEmailProvider();
        EmailProvider makeMoreFriendEmailProvider = new MakeMoreFriendEmailProvider();

        emailSender.setEmailProvider(verifyYourEmailAddressEmailProvider);
        userList.stream()
                .filter(user -> !user.isVerified())
                .forEach(emailSender::sendEmail);

        emailSender.setEmailProvider(makeMoreFriendEmailProvider);
        userList.stream()
                .filter(User::isVerified)
                .filter(user -> user.getFriendUserIds().size() < 3)
                .forEach(emailSender::sendEmail);
    }
}
