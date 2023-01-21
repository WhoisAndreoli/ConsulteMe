package com.example.consulteme.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class Login {

  @PostMapping
  public String login() {
    return "Login feito com sucesso!";
  }
}
