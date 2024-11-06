package com.polarbookshop.orderservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.savedrequest.NoOpServerRequestCache;

@Configuration(proxyBeanMethods = false)
public class SecurityConfig {

    SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
return http
        .authorizeExchange(exchange -> exchange.anyExchange().authenticated()) //All requests require authentication
        .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults())) // OAuth2 Resource Server supports JWT
        .requestCache(requestCacheSpec -> requestCacheSpec.requestCache(NoOpServerRequestCache.getInstance()))
        .csrf(ServerHttpSecurity.CsrfSpec::disable)
        .build();
    }
}
