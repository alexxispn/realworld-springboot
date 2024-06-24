package com.nata.realworldspringboot.users.infrastructure.controllers;

import com.nata.realworldspringboot.users.application.RegisterUser;
import com.nata.realworldspringboot.users.application.params.RegisterUserParams;
import com.nata.realworldspringboot.users.domain.User;
import com.nata.realworldspringboot.users.domain.primitives.UserPrimitives;
import com.nata.realworldspringboot.users.infrastructure.controllers.dtos.RegisterUserResponseDTO;
import com.nata.realworldspringboot.users.infrastructure.controllers.params.RegisterUserControllerParams;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {
    private final RegisterUser registerUser;

    public UsersController(RegisterUser registerUser) {
        this.registerUser = registerUser;
    }

    @PostMapping("/users")
    public ResponseEntity<RegisterUserResponseDTO> register(@RequestBody RegisterUserControllerParams userRequest) {
        RegisterUserParams registerUserParams = new RegisterUserParams(
                userRequest.userId(),
                userRequest.username(),
                userRequest.email(),
                userRequest.password(),
                userRequest.bio());

        User createdUser = this.registerUser.execute(registerUserParams);

        return ResponseEntity.created(null).body(RegisterUserResponseDTO.fromUser(createdUser));
    }
}
