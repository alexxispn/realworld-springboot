package com.nata.realworldspringboot.users.application;

import com.nata.realworldspringboot.users.application.params.RegisterUserParams;
import com.nata.realworldspringboot.users.domain.User;
import com.nata.realworldspringboot.users.domain.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class RegisterUser {

    private final UserRepository userRepository;

    public RegisterUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(RegisterUserParams params) {
        //TODO: Encrypt password

        User user = User.create(
            params.userId(),
            params.username(),
            params.email(),
            params.password(),
            params.bio());

        userRepository.addNewUser(user);

        return user;
    }
}
