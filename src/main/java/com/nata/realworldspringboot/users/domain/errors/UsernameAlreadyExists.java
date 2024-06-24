package com.nata.realworldspringboot.users.domain.errors;

import com.nata.realworldspringboot.common.domain.errors.DomainError;
import com.nata.realworldspringboot.common.domain.errors.DomainErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UsernameAlreadyExists extends DomainError {

  public UsernameAlreadyExists() {
    super(DomainErrorCode.USERNAME_ALREADY_EXISTS);
  }
}
