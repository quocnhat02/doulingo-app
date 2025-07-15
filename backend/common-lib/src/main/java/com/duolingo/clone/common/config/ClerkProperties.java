package com.duolingo.clone.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "clerk")
@Getter
@Setter
public class ClerkProperties {
    private String jwtPublicKey;
}