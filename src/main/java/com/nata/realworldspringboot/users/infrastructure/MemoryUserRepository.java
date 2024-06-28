package com.nata.realworldspringboot.users.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.nata.realworldspringboot.users.domain.Email;
import com.nata.realworldspringboot.users.domain.User;
import com.nata.realworldspringboot.users.domain.Username;
import com.nata.realworldspringboot.users.domain.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class MemoryUserRepository extends UserRepository {
    private final List<User> users;

    public MemoryUserRepository() {
        this.users = new ArrayList<>();
    }

    @Override
    protected void save(User user) {
        this.users.add(user);
    }

    @Override
    public Optional<User> findByUsername(Username username) {
        return users.stream().filter(user -> user.hasUsername(username)).findFirst();
    }

    @Override
    public Optional<User> findByEmail(Email email) {
        return users.stream().filter(user -> user.hasEmail(email)).findFirst();
    }
}
