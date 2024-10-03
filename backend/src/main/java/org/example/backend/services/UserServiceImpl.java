package org.example.backend.services;

import lombok.RequiredArgsConstructor;
import org.example.backend.dtos.LoginRequestDto;
import org.example.backend.dtos.LoginResponseDto;
import org.example.backend.models.User;
import org.example.backend.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final AuthService authService;

  @Override
  public LoginResponseDto login(LoginRequestDto loginRequestDto) {

    User user = User.builder()

            .username(loginRequestDto.username())
            .password(this.passwordEncoder.encode(loginRequestDto.password()))
            .build();

    if (userRepository.findByUsername(loginRequestDto.username()).equals(user)) {
      return new LoginResponseDto(authService.generateToken(user));
    }
    userRepository.save(user);

    return new LoginResponseDto(authService.generateToken(user));
  }

  @Override
  public void loadUsers() {
    if (userRepository.findAll().isEmpty()) {
      userRepository.save(User.builder().username("Admin1").password("Password123").build());
      userRepository.save(User.builder().username("Admin2").password("Password124").build());
      userRepository.save(User.builder().username("Admin3").password("Password125").build());
    }
  }
}
