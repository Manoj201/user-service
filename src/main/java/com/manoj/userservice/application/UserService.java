package com.manoj.userservice.application;

import com.manoj.userservice.dto.login.LoginDTO;
import com.manoj.userservice.dto.login.SignUpDTO;
import com.manoj.userservice.persistance.entity.User;

import java.util.UUID;

public interface UserService {

  User signUp(SignUpDTO payload);

  User findByUsername(String userName);

  UUID getLoginToken(LoginDTO payload);

  User findById(UUID id);
}
