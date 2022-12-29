package com.study.javastream.pattern.buider;

public class BuilderPattern {

    public static void main(String[] args) {
        User user = User.builder(1, "wook")
                .withEmailAddress("wook@naver.com")
                .withVerified(true)
                .build();
        System.out.println("user = " + user);

        UserComsumer userComsumer = UserComsumer.builder(1, "test")
                .with(builder -> {
                    builder.emailAddress = "test@naver.com";
                    builder.isVerified = true;
                })
                .build();
        System.out.println("userComsumer = " + userComsumer);
    }
}
