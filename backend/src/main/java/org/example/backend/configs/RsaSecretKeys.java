package org.example.backend.configs;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import lombok.Getter;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class RsaSecretKeys {

  private final RSAPublicKey publicKey;
  private final RSAPrivateKey privateKey;

  public RsaSecretKeys() throws NoSuchAlgorithmException {
    KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
    KeyPair keyPair = generator.generateKeyPair();
    this.publicKey = (RSAPublicKey) keyPair.getPublic();
    this.privateKey = (RSAPrivateKey) keyPair.getPrivate();
  }

}
