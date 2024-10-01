package org.example.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.example.backend.dtos.LoginRequestDto;
import org.example.backend.dtos.LoginResponseDto;
import org.example.backend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/login")
  public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
    return ResponseEntity.status(HttpStatus.OK).body(userService.login(loginRequestDto));

  }
}
