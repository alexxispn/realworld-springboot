package com.nata.realworldspringboot.users.application.useCases;

import com.nata.realworldspringboot.users.application.params.RegisterUserParams;
import com.nata.realworldspringboot.users.domain.User;
import com.nata.realworldspringboot.users.domain.Username;
import com.nata.realworldspringboot.users.domain.errors.EmailAlreadyExistsError;
import com.nata.realworldspringboot.users.domain.errors.UsernameAlreadyExists;
import com.nata.realworldspringboot.users.domain.primitives.UserPrimitives;
import com.nata.realworldspringboot.users.infrastructure.MemoryUserRepository;
import com.nata.realworldspringboot.users.application.RegisterUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.nata.realworldspringboot.users.mothers.UserMother.juan;
import static com.nata.realworldspringboot.users.mothers.UserMother.juanAltAccount;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RegisterUserTest {

    @Spy
    private MemoryUserRepository usersRepository;

    @InjectMocks
    RegisterUser registerUser;


    @Test
    void registers_a_user_successfully() {
        User juan = juan();
        UserPrimitives juanPrimitives = juan.toPrimitives();
        RegisterUserParams params = new RegisterUserParams(juanPrimitives.userId(), juanPrimitives.username(), juanPrimitives.email(), juanPrimitives.password(), juanPrimitives.bio());

        User response = registerUser.execute(params);

        assertEquals(juan, response);
        verify(usersRepository).addNewUser(juan);

    }

    @Test
    void fails_if_username_already_exists() {
        User juan = juan();
        User juanAltAccount = juanAltAccount();
        UserPrimitives juanPrimitives = juan.toPrimitives();
        RegisterUserParams params = new RegisterUserParams(juanPrimitives.userId(), juanPrimitives.username(), juanPrimitives.email(), juanPrimitives.password(), juanPrimitives.bio());

        usersRepository.addNewUser(juanAltAccount);

        assertThrows(UsernameAlreadyExists.class,()->registerUser.execute(params));

        verify(usersRepository).addNewUser(juan);
    }

    @Test
    void fails_if_email_already_exists() {
        User juan = juan();
        User juanAltAccount = juanAltAccount();
        juanAltAccount.updateUsername(Username.create("juanAltAccount"));
        UserPrimitives juanPrimitives = juan.toPrimitives();
        RegisterUserParams params = new RegisterUserParams(juanPrimitives.userId(), juanPrimitives.username(), juanPrimitives.email(), juanPrimitives.password(), juanPrimitives.bio());

        usersRepository.addNewUser(juanAltAccount);

        assertThrows(EmailAlreadyExistsError.class,()->registerUser.execute(params));

        verify(usersRepository).addNewUser(juan);
    }
}
