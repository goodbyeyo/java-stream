package com.study.javastream.pattern.templateMethod;

import com.study.javastream.optional.User;

public class TemplateMethodPattern {

    public static void main(String[] args) {

        UserService userService = new UserService();
        InternalUserService internalUserService = new InternalUserService();
        userService.createUser(User.getUserList().get(1));
        internalUserService.createUser(User.getUserList().get(1));

        /**
         * 템플릿을 적용한 인스턴스
         */
        UserServiceInFunctionalWay userServiceInFunctionalWay = new UserServiceInFunctionalWay(
            // UserService.validateUser() 메서드
            user -> {
                System.out.println("Validating user " + user.getName());
                return user.getName() != null && user.getEmailAddress().isPresent();
            },
            // UserService.writeToDB() 메서드
            user -> {
                System.out.println("Writing user " + user.getName() + " to DB");
            });
        userServiceInFunctionalWay.createUser(User.getUserList().get(0));

    }
}

