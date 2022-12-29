package com.study.javastream.pattern.templateMethod;


import com.study.javastream.optional.User;

public class UserService extends AbstractUserService{

    @Override
    protected boolean validateUser(User user) {
        System.out.println("Validating user " + user.getName());
        return user.getName() != null && user.getEmailAddress().isPresent();
    }

    @Override
    protected void writeToDB(User user) {
        System.out.println("Writing user " + user.getName() + " to DB");
    }
}
