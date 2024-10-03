package org.example.backend.services;

import lombok.RequiredArgsConstructor;
import org.example.backend.configs.JwtConfig;
import org.example.backend.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
  private final JwtEncoder jwtEncoder;
  private final JwtConfig jwtConfig;

  @Override
  public String generateToken(User user) {
    Instant now = Instant.now();

    long expiry = jwtConfig.getExpirationTime();

    String scope = user.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(" "));
    JwtClaimsSet claims = JwtClaimsSet.builder()
            .issuer("self")
            .issuedAt(now)
            .expiresAt(now.plusSeconds(expiry))
            .subject(user.getUsername())
            .claim("scope", scope)
            .build();

    return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
  }
}
