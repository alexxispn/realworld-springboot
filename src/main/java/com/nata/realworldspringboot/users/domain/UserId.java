package com.nata.realworldspringboot.users.domain;

import java.util.UUID;

import com.nata.realworldspringboot.common.domain.SingleValueObject;
import com.nata.realworldspringboot.users.domain.errors.InvalidUserId;

public class UserId extends SingleValueObject<String> {

  public UserId(String value) {
    super(value);
  }

  public static UserId create(String userId) {
    if (userId == null) {
      throw new InvalidUserId();
    }
    validateIsUUID(userId);
    return new UserId(userId);
  }

  private static void validateIsUUID(String userId) {
    try{
      UUID.fromString(userId);
    }
    catch (IllegalArgumentException e){
      throw new InvalidUserId();
    }
  }
}
