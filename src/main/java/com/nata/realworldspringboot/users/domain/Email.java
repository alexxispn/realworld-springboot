package com.nata.realworldspringboot.users.domain;

import com.nata.realworldspringboot.common.domain.SingleValueObject;

public class Email extends SingleValueObject<String> {

  public Email(String value) {
    super(value);
  }

  public static Email create(String value){
    if(value == null || value.isEmpty()){
      throw new IllegalArgumentException("Email cannot be empty");
    }
    if(!value.matches("^[A-Za-z0-9+_.-]+@(.+)$")){
      throw new IllegalArgumentException("Email is invalid");
    }
    return new Email(value);
  }


}
