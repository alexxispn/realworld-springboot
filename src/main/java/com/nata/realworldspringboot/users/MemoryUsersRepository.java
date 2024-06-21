package com.nata.realworldspringboot.users;

import java.util.List;

public class MemoryUsersRepository implements UsersRepository {
    private List<User> users = List.of();

    @Override
    public User save(User user) {
        this.users.add(user);
        return user;
    }
}
