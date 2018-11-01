package com.manoj.userservice.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class UserDTO {

  private String fullName;

  private String username;

  private String phoneNo;
}
