package com.github.shaart.smactbus.sample.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class HomeController {

  @GetMapping
  public String home() {
    return "hello";
  }

  @GetMapping("/api/user")
  @PreAuthorize("hasRole('USER')")
  public Object userHome(Authentication authentication) {
    return authentication.getDetails();
  }

  @GetMapping("/api/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public Object adminHome(Authentication authentication) {
    return authentication.getDetails();
  }
}
