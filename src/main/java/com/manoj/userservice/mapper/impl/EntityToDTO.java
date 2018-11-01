package com.manoj.userservice.mapper.impl;

import com.manoj.userservice.dto.user.UserDTO;
import com.manoj.userservice.mapper.EntityToDtoMapper;
import com.manoj.userservice.persistance.entity.User;
import org.springframework.stereotype.Service;

@Service
public class EntityToDTO implements EntityToDtoMapper {
  @Override
  public UserDTO getUserDTOFromUser(User payload) {
    return UserDTO.builder()
        .username(payload.getUsername())
        .fullName(payload.getFirstName()+ " "+ payload.getLastName())
        .phoneNo(payload.getPhoneNo())
        .build();
  }
}
