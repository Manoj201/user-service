package com.manoj.userservice.controller;

import com.manoj.userservice.application.UserService;
import com.manoj.userservice.dto.login.LoginDTO;
import com.manoj.userservice.dto.login.LoginResponseDTO;
import com.manoj.userservice.dto.base.ResponseDTO;
import com.manoj.userservice.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserService userService;


  @Autowired
  private JwtTokenProvider tokenProvider;

  @PostMapping("/signin")
  public ResponseDTO<LoginResponseDTO> authentication(@RequestBody LoginDTO payload) {
    Authentication authenticate = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            payload.getUsername(),
            payload.getPassword()
        )
    );

    SecurityContextHolder.getContext().setAuthentication(authenticate);

    String Jwt = "";
    if (authenticate.isAuthenticated()) {
      Jwt = tokenProvider.generateToken(userService.findByUsername(payload.getUsername()).getId());
    }
    return ResponseDTO.ok(LoginResponseDTO.builder()
        .token(Jwt).build());
  }
}
