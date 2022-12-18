package com.study.javastream.functional_interface;

import com.study.javastream.functional_interface.model.User;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorInterface {

    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        users.add(new User(3, "Hero"));
        users.add(new User(1, "Jim"));
        users.add(new User(7, "Alice"));
        System.out.println("users = " + users.toString());

        Comparator<User> idComparator = (u1, u2) -> u1.getId() - u2.getId();
        users.sort(idComparator); // Collections.sort(users, idComparator);
        System.out.println("sorted by id = " + users.toString());

        // compareTo : 뒤의 인자가 크면 음수, 같으면 0, 앞의 인자가 크면 양수
        users.sort((u1, u2) -> u1.getName().compareTo(u2.getName()));
        // Collections.sort(users, (u1, u2) -> u1.getName().compareTo(u2.getName()));
        System.out.println("sorted by name = " + users.toString());
    }
}

