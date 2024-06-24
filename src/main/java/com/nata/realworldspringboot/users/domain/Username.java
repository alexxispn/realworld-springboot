package com.nata.realworldspringboot.users.domain;

import com.nata.realworldspringboot.common.domain.SingleValueObject;

public class Username extends SingleValueObject<String> {

  public Username(String value) {
    super(value);
  }

  public static Username create(String value){
    if(value == null || value.isEmpty()){
      throw new IllegalArgumentException("Username cannot be empty");
    }
    if(value.length() < 3 || value.length() > 20){
      throw new IllegalArgumentException("Username must be between 3 and 20 characters");
    }
    return new Username(value);
  }


}
