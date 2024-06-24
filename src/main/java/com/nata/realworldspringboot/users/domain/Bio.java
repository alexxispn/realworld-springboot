package com.nata.realworldspringboot.users.domain;

import com.nata.realworldspringboot.common.domain.SingleValueObject;

public class Bio extends SingleValueObject<String> {

  public Bio(String value) {
    super(value);
  }

  public static Bio create(String value){
          if(value == null || value.isEmpty()){
              throw new IllegalArgumentException("Bio cannot be empty");
          }
          if(value.length() > 100){
              throw new IllegalArgumentException("Bio must be at most 100 characters");
          }
          return new Bio(value);
      }

}
