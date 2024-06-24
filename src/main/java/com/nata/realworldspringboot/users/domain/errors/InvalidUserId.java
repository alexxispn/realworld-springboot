package com.nata.realworldspringboot.users.domain.errors;

import com.nata.realworldspringboot.common.domain.errors.DomainError;
import com.nata.realworldspringboot.common.domain.errors.DomainErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidUserId extends DomainError {

  public InvalidUserId() {
    super(DomainErrorCode.INVALID_USER_ID);
  }
}
