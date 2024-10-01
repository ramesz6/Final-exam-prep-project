package org.example.backend.services;

import lombok.RequiredArgsConstructor;
import org.example.backend.configs.JwtConfig;
import org.example.backend.models.User;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
  private final JwtEncoder jwtEncoder;
  private final JwtConfig jwtConfig;

  @Override
  public String generateToken(User user) {
    return null;
  }
}
