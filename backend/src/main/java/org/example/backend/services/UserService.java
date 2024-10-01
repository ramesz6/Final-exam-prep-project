package org.example.backend.services;

import org.example.backend.dtos.LoginRequestDto;
import org.example.backend.dtos.LoginResponseDto;

public interface UserService {
  LoginResponseDto login(LoginRequestDto loginRequestDto);

  void loadUsers();
}
