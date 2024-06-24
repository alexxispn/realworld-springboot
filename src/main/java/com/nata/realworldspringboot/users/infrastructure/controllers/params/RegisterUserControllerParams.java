package com.nata.realworldspringboot.users.infrastructure.controllers.params;

public record RegisterUserControllerParams(String userId, String username, String email, String password, String bio) {

}