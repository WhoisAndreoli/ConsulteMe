package com.example.consulteme.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class Login {

  @GetMapping("/atendente")
  @PreAuthorize("hasAuthority('ATENDENTE')")
  public String atendente() {
    return "ola atendente";
  }

  @GetMapping("/medico")
  @PreAuthorize("hasAuthority('MEDICO')")
  public String medico() {
    return "ola medico";
  }
}
