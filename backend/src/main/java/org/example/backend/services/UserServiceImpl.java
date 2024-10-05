package org.example.backend.services;

import lombok.RequiredArgsConstructor;
import org.example.backend.dtos.LoginRequestDto;
import org.example.backend.dtos.LoginResponseDto;
import org.example.backend.errors.CannotVerifyUserError;
import org.example.backend.models.User;
import org.example.backend.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final AuthService authService;

  @Override
  public LoginResponseDto login(LoginRequestDto loginRequestDto) throws CannotVerifyUserError,
      UsernameNotFoundException {
    User user = userRepository.findByUsername(loginRequestDto.username())
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    if (!user.isEnabled()) {
      throw new CannotVerifyUserError("User's email is not verified");
    } else if (!passwordEncoder.matches(loginRequestDto.password(), user.getPassword())) {
      throw new UsernameNotFoundException("Invalid password");
    }
    return new LoginResponseDto(authService.generateToken(user));
  }

  @Override
  public void loadUsers() {
    if (userRepository.findAll().isEmpty()) {
      userRepository.save(User.builder()
          .username("Admin1")
          .password(passwordEncoder
              .encode("password123"))
          .build());
      userRepository.save(User.builder()
          .username("Admin2")
          .password(passwordEncoder
              .encode("password123"))
          .build());
      userRepository.save(User.builder()
          .username("Admin3")
          .password(passwordEncoder
              .encode("password123"))
          .build());
    }
  }
}
