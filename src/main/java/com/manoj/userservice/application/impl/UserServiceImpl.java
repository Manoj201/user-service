package com.manoj.userservice.application.impl;

import com.manoj.userservice.application.UserService;
import com.manoj.userservice.dto.login.LoginDTO;
import com.manoj.userservice.dto.login.SignUpDTO;
import com.manoj.userservice.mapper.DtoToEntityMapper;
import com.manoj.userservice.persistance.entity.User;
import com.manoj.userservice.persistance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private DtoToEntityMapper dtoToEntityMapper;

  @Override
  public User signUp(SignUpDTO payload) {
    User userFromSignUpDTo = dtoToEntityMapper.getUserFromSignUpDTo(payload);
    return userRepository.save(userFromSignUpDTo);
  }

  @Override
  public User findByUsername(String userName) {
    return userRepository.findByUsername(userName);
  }

  @Override
  public UUID getLoginToken(LoginDTO payload) {

    User user = userRepository.findByUsername(payload.getUsername());

    return null;
  }

  @Override
  public User findById(UUID id) {
    return userRepository.findById(id).get();
  }

}
