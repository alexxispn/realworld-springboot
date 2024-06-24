package com.nata.realworldspringboot.common.domain.errors;

import org.springframework.web.bind.annotation.ResponseBody;

public abstract class DomainError extends RuntimeException {

  private final DomainErrorCode errorCode;

  public DomainError(DomainErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }

}
