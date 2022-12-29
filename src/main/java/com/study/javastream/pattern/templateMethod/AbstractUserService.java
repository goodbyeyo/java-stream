package com.study.javastream.pattern.templateMethod;

import com.study.javastream.optional.User;

public abstract class AbstractUserService {
    protected abstract boolean validateUser(User user);

    protected abstract void writeToDB(User user);

    public void createUser(User user) {
        if (validateUser(user)) {
            writeToDB(user);
        } else {
            System.out.println("Can not create user");
        }
    }
}
