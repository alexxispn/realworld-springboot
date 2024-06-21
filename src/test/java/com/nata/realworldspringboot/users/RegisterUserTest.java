package com.nata.realworldspringboot.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RegisterUserTest {
    private MemoryUsersRepository usersRepository;

    @BeforeEach
    void setUp() {
        usersRepository = new MemoryUsersRepository();
    }

    @Test
    void registers_a_user_successfully() {
        RegisterUser registerUser = new RegisterUser(usersRepository);
        User result = registerUser.execute();

        assertNotNull(result);
    }
}
