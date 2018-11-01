package com.manoj.userservice.mapper;

import com.manoj.userservice.dto.login.SignUpDTO;
import com.manoj.userservice.persistance.entity.User;

public interface DtoToEntityMapper {
  User getUserFromSignUpDTo(SignUpDTO payload);
}
