package com.manoj.userservice.dto.login;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Builder
public class LoginDTO {

  private String username;

  private String password;

  @Tolerate
  public LoginDTO () {}
}
