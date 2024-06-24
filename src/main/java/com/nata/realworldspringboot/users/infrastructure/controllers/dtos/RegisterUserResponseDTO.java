package com.nata.realworldspringboot.users.infrastructure.controllers.dtos;

import com.nata.realworldspringboot.users.domain.User;
import com.nata.realworldspringboot.users.domain.primitives.UserPrimitives;

public record RegisterUserResponseDTO(String userId, String username, String email, String bio){

  public static RegisterUserResponseDTO fromUser(User user){
    UserPrimitives userPrimitives = user.toPrimitives();
    return new RegisterUserResponseDTO(userPrimitives.userId(), userPrimitives.username(), userPrimitives.email(), userPrimitives.bio());
  }
}
