package com.nata.realworldspringboot.common.domain.errors;

public enum DomainErrorCode {
  USERNAME_ALREADY_EXISTS,
  EMAIL_ALREADY_EXISTS,
  INVALID_USER_ID;


  public String getMessage() {
    return switch (this) {
      case USERNAME_ALREADY_EXISTS -> "Username already exists";
      case EMAIL_ALREADY_EXISTS -> "Email already exists";
      case INVALID_USER_ID -> "User ID is invalid";
    };
  }
}
