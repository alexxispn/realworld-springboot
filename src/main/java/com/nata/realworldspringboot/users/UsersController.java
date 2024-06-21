package com.nata.realworldspringboot.users;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @PostMapping
    public ResponseEntity<Object> register(@RequestBody UserRequest userRequest) {
        return ResponseEntity.created(null).build();
    }

    @GetMapping
    public ResponseEntity<Object> get() {
        return ResponseEntity.ok().build();
    }

}
