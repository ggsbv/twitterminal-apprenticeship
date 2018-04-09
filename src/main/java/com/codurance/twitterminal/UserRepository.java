package com.codurance.twitterminal;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public void store(User user) {
        if (! users.contains(user)) users.add(user);
    }

    public List<User> all() {
        return users;
    }

}
