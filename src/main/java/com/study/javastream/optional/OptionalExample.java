package com.study.javastream.optional;

import com.study.javastream.stream.model.User;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        //nullPointExceptionTest();
        optionalTest();
        advancedOptionalTest();
    }

    private static void advancedOptionalTest() {
        Optional<User> maybeUser = Optional.ofNullable(maybeGetUser(true));
        maybeUser.ifPresent(System.out::println);
        Optional.ofNullable(maybeGetUser(true))
                .map(User::getId);
    }

    public static User maybeGetUser(boolean returnUser) {
        if (returnUser) {
            return User.builder()
                    .id(1)
                    .name("Mary")
                    .emailAddress("mary@gmail.com")
                    .isVerified(false)
                    .build();
        }
        return null;
    }

    private static void optionalTest() {
        String someEmail = "some@naver.com";
        String nullEmail = null;

        Optional<String> maybeEmail = Optional.of(someEmail);
        Optional<String> maybeEmail2 = Optional.empty();
        Optional<String> maybeEmail3 = Optional.ofNullable(someEmail);
        Optional<String> maybeEmail4 = Optional.ofNullable(nullEmail);
        String email = maybeEmail.get();
        System.out.println("email = " + email);
        if (maybeEmail2.isPresent()) {
            System.out.println(maybeEmail2.get());
        }
        String defaultEmail = "default@naver.com";
        String email3 = maybeEmail2.orElse(defaultEmail);
        System.out.println("email3 = " + email3);

        String email4 = maybeEmail2.orElseGet(() -> defaultEmail);
        System.out.println("email4 = " + email4);
        String email5 = maybeEmail2.orElseThrow(() -> new RuntimeException("Email Not Present"));
    }

    private static void nullPointExceptionTest() {
        User user1 = User.builder()
                .id(1)
                .name("Mary")
                .isVerified(false)
                .build();

        User user2 = User.builder()
                .id(1)
                .name("Mary")
                .emailAddress("wook@naver.com")
                .isVerified(false)
                .build();

        // user1.getEmailAddress 에서 nullPointException 발생
        System.out.println("Same ? " + userEquals(user1, user2));
    }

    public static boolean userEquals(User u1, User u2) {
        return u1.getId() == u2.getId()
                && u1.getName().equals(u2.getName())
                && u1.getEmailAddress().equals(u2.getEmailAddress())
                && u1.isVerified() == u2.isVerified();
    }

}
