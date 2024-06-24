package com.nata.realworldspringboot.users.domain;

import com.nata.realworldspringboot.common.domain.SingleValueObject;

public class Password extends SingleValueObject<String> {

  public Password(String value) {
    super(value);
  }

  public static Password create(String value){
      if(value == null || value.isEmpty()){
        throw new IllegalArgumentException("Password cannot be empty");
      }
      if(value.length() < 8){
        throw new IllegalArgumentException("Password must be at least 8 characters");
      }
      return new Password(value);
    }


}
