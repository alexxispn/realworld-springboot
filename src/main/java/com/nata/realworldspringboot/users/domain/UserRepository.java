package com.nata.realworldspringboot.users.domain;

import java.util.Optional;

import com.nata.realworldspringboot.users.domain.errors.EmailAlreadyExistsError;
import com.nata.realworldspringboot.users.domain.errors.UsernameAlreadyExists;

public interface UserRepository {

    default void ensureNewUserCanBeAdded(User user) {
        if(findByUsername(user.getUsername()).isPresent()){
            throw new UsernameAlreadyExists();
        }
        if(findByEmail(user.getEmail()).isPresent()){
            throw new EmailAlreadyExistsError();
        }
    }
    
    void addNewUser(User user);

    Optional<User> findByUsername(Username username);

    Optional<User> findByEmail(Email email);
}
