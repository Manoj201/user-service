package com.manoj.userservice.controller;

import com.manoj.userservice.application.UserService;
import com.manoj.userservice.dto.base.ResponseDTO;
import com.manoj.userservice.dto.login.SignUpDTO;
import com.manoj.userservice.dto.user.UserDTO;
import com.manoj.userservice.mapper.EntityToDtoMapper;
import com.manoj.userservice.persistance.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


  @Autowired
  private UserService userService;

  @Autowired
  private EntityToDtoMapper mapper;

  @PostMapping("/signup")
  public ResponseDTO<UserDTO> signUp(@RequestBody SignUpDTO payload) {

    User user = userService.signUp(payload);
    return ResponseDTO.ok(mapper.getUserDTOFromUser(user));
  }

//  @PostMapping
//  public ResponseDTO<UserDTO> login(@RequestBody LoginDTO loginData) {
//    return null;
//  }

  @GetMapping("/{username}")
  public ResponseDTO<UserDTO> getUserProfile(@PathVariable(value = "username") String username) {

    User userProfile = userService.findByUsername(username);
    UserDTO userDTOFromUser = mapper.getUserDTOFromUser(userProfile);

    return ResponseDTO.ok(userDTOFromUser);
  }

}
