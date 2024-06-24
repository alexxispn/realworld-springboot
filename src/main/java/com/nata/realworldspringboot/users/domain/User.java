package com.nata.realworldspringboot.users.domain;

import java.util.Objects;

import com.nata.realworldspringboot.users.domain.primitives.UserPrimitives;

public class User {

    private final UserId userId;

    private Username username;

    private final Email email;

    private final Password password;

    private final Bio bio;

    private User(UserId userId, Username username, Email email, Password password, Bio bio) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.bio = bio;
    }

    public static User create(String userId, String username, String email, String password, String bio) {
        return new User(
            UserId.create(userId),
            Username.create(username),
            Email.create(email),
            Password.create(password),
            Bio.create(bio));
    }

    public Username getUsername() {
        return username;
    }

    public Email getEmail() {
        return email;
    }

    public boolean hasUsername(Username username) {
        return this.username.equals(username);
    }

    public boolean hasEmail(Email email) {
        return this.email.equals(email);
    }

    public UserPrimitives toPrimitives() {
        return new UserPrimitives(
            userId.toPrimitives(),
            username.toPrimitives(),
            email.toPrimitives(),
            password.toPrimitives(),
            bio.toPrimitives()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    public void updateUsername(Username newUsername) {
        this.username = newUsername;
    }
}
