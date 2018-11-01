package com.manoj.userservice.mapper.impl;

import com.manoj.userservice.dto.login.SignUpDTO;
import com.manoj.userservice.mapper.DtoToEntityMapper;
import com.manoj.userservice.persistance.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DtoToEntity implements DtoToEntityMapper {

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public User getUserFromSignUpDTo(SignUpDTO payload) {
    return User.builder()
        .id(UUID.randomUUID())
        .firstName(payload.getFirstName())
        .lastName(payload.getLastName())
        .username(payload.getUsername())
        .password( bCryptPasswordEncoder.encode(payload.getPassword()))
        .phoneNo(payload.getPhoneNo())
        .build();
  }
}
