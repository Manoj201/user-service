package com.manoj.userservice.dto.login;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.util.UUID;

@Getter
@Setter
@Builder
public class SignUpDTO {

  private UUID id;

  private String firstName;

  private String lastName;

  private String username;

  private String phoneNo;

  private String password;

  @Tolerate
  public SignUpDTO(){}
}
