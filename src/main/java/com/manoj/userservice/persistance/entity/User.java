package com.manoj.userservice.persistance.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@Table(name = "\"user\"")
public class User {

  @Id
  private UUID id;

  private String firstName;

  private String lastName;

  private String username;

  private String phoneNo;

  private String password;

  @Tolerate
  public User() {}
}
