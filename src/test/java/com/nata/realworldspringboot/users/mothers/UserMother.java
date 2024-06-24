package com.nata.realworldspringboot.users.mothers;

import com.nata.realworldspringboot.users.domain.User;

public class UserMother {


  public static User juan() {
    return User.create(
        "394f1f4b-1f4b-4f1f-94f1-4b1f4f1f4b1f",
        "juanito_23",
        "juanito_23@mail.com",
        "password",
        "I'm Juan");
  }
  public static User juanAltAccount(){
    return User.create(
        "1c53f520-4e7f-4b0b-982a-a9fbc9180bfc",
        juan().toPrimitives().username(),
        juan().toPrimitives().email(),
        juan().toPrimitives().password(),
        juan().toPrimitives().bio());

  }
}
