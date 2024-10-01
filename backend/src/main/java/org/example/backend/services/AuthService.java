package org.example.backend.services;

import org.example.backend.models.User;

public interface AuthService {
  String generateToken(User user);
}
