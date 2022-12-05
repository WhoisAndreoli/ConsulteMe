package com.example.consulteme.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consulteme.dtos.ConsultaPatchRequest;
import com.example.consulteme.dtos.ConsultaResponse;
import com.example.consulteme.services.MedicoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/medico")
@AllArgsConstructor
public class MedicoController {

  private MedicoService service;

  @PatchMapping("/finalizar-consulta/{id}")
  public ResponseEntity<ConsultaResponse> finalizarConsulta(@Valid @PathVariable Long id,
      @RequestBody ConsultaPatchRequest request) {
    return new ResponseEntity<>(service.finalizarConsulta(id, request), HttpStatus.OK);
  }
}