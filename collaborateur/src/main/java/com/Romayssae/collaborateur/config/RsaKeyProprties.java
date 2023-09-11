package com.Romayssae.collaborateur.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@ConfigurationProperties(prefix = "rsa")
public record RsaKeyProprties(RSAPublicKey publicKey, RSAPrivateKey privateKey) {


}
