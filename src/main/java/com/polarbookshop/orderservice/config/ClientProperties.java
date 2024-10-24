package com.polarbookshop.orderservice.config;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URI;

@ConfigurationProperties("polar")
public record ClientProperties (
        String welcomeMessage,
        @NotNull
        URI catalogServiceUri,
        @NotNull
        int catalogServiceTimeout,
        @NotNull
        int maxRetryAttempt
) {
}
