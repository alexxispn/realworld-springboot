package com.nata.realworldspringboot.users;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {
    private final RegisterUser registerUser;

    public UsersController(RegisterUser registerUser) {
        this.registerUser = registerUser;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> register(@RequestBody UserRequest userRequest) {
        var response = this.registerUser.execute();
        return ResponseEntity.created(null).body(response);
    }
}
