package com.example.consulteme.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consulteme.dtos.MedicoRequest;
import com.example.consulteme.dtos.MedicoResponse;
import com.example.consulteme.services.GerenteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class GerenteController {

  private GerenteService service;

  @PostMapping("/gerente/criar-medico")
  public ResponseEntity<MedicoResponse> criarMedico(@RequestBody MedicoRequest medicoRequest) {
    return new ResponseEntity<>(service.criarMedico(medicoRequest), HttpStatus.CREATED);
  }
}
