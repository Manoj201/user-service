package com.manoj.userservice.mapper;

import com.manoj.userservice.dto.user.UserDTO;
import com.manoj.userservice.persistance.entity.User;

public interface EntityToDtoMapper {

  UserDTO getUserDTOFromUser(User payload);
}
