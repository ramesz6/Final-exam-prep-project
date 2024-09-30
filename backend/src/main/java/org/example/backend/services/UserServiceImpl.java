package org.example.backend.services;

import lombok.RequiredArgsConstructor;
import org.example.backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
}
