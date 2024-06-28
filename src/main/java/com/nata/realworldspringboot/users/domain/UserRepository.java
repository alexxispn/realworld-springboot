package com.nata.realworldspringboot.users.domain;

import java.util.Optional;

import com.nata.realworldspringboot.users.domain.errors.EmailAlreadyExistsError;
import com.nata.realworldspringboot.users.domain.errors.UsernameAlreadyExists;

public abstract class UserRepository {

    private void ensureNewUserCanBeAdded(User user) {
        if(findByUsername(user.getUsername()).isPresent()){
            throw new UsernameAlreadyExists();
        }
        if(findByEmail(user.getEmail()).isPresent()){
            throw new EmailAlreadyExistsError();
        }
    }

    public final void addNewUser(User user){
        ensureNewUserCanBeAdded(user);
        save(user);
    };

    protected abstract void save(User user);

    protected abstract Optional<User> findByUsername(Username username);

    protected abstract Optional<User> findByEmail(Email email);
}
