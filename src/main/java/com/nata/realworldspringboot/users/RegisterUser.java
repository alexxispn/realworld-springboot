package com.nata.realworldspringboot.users;

import org.springframework.stereotype.Component;

@Component
public class RegisterUser {
    private UsersRepository usersRepository;

    public RegisterUser(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User execute() {
        return null;
    }
}
