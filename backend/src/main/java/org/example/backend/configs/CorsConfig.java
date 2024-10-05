package org.example.backend.configs;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class CorsConfig {
  @Value("${cors.urls}")
  private String corsUrls;
}