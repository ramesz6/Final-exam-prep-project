package org.example.backend.configs;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class JwtConfig {
  @Value("${jwt.expiration-time}")
  private Long expirationTime;
}