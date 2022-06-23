package com.github.shaart.smactbus.sample.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class HomeController {

  @GetMapping
  public String home(Authentication authentication) {
    return "hello, user_name = %s with authorities = %s"
        .formatted(
            ((Jwt) authentication.getCredentials()).getClaim("user_name"),
            authentication.getAuthorities()
        );
  }

  @GetMapping("/api/user")
  @PreAuthorize("hasRole('USER')")
  public Object userHome(Authentication authentication) {
    return "hello USER with user_name = %s and authorities = %s"
        .formatted(
            ((Jwt) authentication.getCredentials()).getClaim("user_name"),
            authentication.getAuthorities()
        );
  }

  @GetMapping("/api/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public Object adminHome(Authentication authentication) {
    return "hello ADMIN with user_name = %s and authorities = %s"
        .formatted(
            ((Jwt) authentication.getCredentials()).getClaim("user_name"),
            authentication.getAuthorities()
        );
  }
}
