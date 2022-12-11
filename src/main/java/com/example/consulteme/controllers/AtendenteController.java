package com.example.consulteme.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consulteme.dtos.ConsultaRequest;
import com.example.consulteme.dtos.ConsultaResponse;
import com.example.consulteme.dtos.PacienteDTO;
import com.example.consulteme.dtos.PacientePatchRequest;
import com.example.consulteme.services.AtendenteService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/atendente")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AtendenteController {

  AtendenteService service;

  @PostMapping("/criar-paciente")
  public ResponseEntity<PacienteDTO> criarPaciente(@Valid @RequestBody PacienteDTO paciente) {
    return new ResponseEntity<>(service.criarPaciente(paciente), HttpStatus.CREATED);
  }

  @GetMapping("/buscar-paciente/{cpf}")
  public ResponseEntity<PacienteDTO> buscarPaciente(@Valid @PathVariable String cpf) {
    return new ResponseEntity<>(service.buscarPaciente(cpf), HttpStatus.OK);
  }

  @GetMapping("/buscar-paciente")
  public ResponseEntity<List<PacienteDTO>> buscarPaciente() {
    return new ResponseEntity<>(service.buscarPaciente(), HttpStatus.OK);
  }

  @PatchMapping("/atualizar-paciente/{cpf}")
  public ResponseEntity<PacienteDTO> atualizarPaciente(@PathVariable String cpf,
      @Valid @RequestBody PacientePatchRequest request) {
    return new ResponseEntity<>(service.atualizarPaciente(cpf, request), HttpStatus.OK);
  }

  @PostMapping("/criar-consulta")
  public ResponseEntity<ConsultaResponse> criarConsulta(@Valid @RequestBody ConsultaRequest consultaRequest) {
    return new ResponseEntity<>(service.criarConsulta(consultaRequest), HttpStatus.CREATED);
  }

  @GetMapping("/buscar-consulta")
  public List<ConsultaResponse> buscarConsulta() {
    return service.buscarConsulta();
  }
}
