package com.nata.realworldspringboot.users.application.params;

public record RegisterUserParams(String userId, String username, String email, String password, String bio) {

}