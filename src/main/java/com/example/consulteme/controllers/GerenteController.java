package com.example.consulteme.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consulteme.dtos.AtendentePatchRequest;
import com.example.consulteme.dtos.AtendenteRequest;
import com.example.consulteme.dtos.AtendenteResponse;
import com.example.consulteme.dtos.MedicoPatchRequest;
import com.example.consulteme.dtos.MedicoRequest;
import com.example.consulteme.dtos.MedicoResponse;
import com.example.consulteme.services.GerenteService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/gerente")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class GerenteController {

  private GerenteService service;

  @PreAuthorize("hasAuthority('GERENTE')")
  @PostMapping("/criar-medico")
  public ResponseEntity<MedicoResponse> criarMedico(@Valid @RequestBody MedicoRequest medicoRequest) {
    return new ResponseEntity<>(service.criarMedico(medicoRequest), HttpStatus.CREATED);
  }

  @PreAuthorize("hasAuthority('GERENTE')")
  @GetMapping("/buscar-medico/{crm}")
  public ResponseEntity<MedicoResponse> buscarMedico(@Valid @PathVariable String crm) {
    return new ResponseEntity<>(service.buscarMedico(crm), HttpStatus.OK);
  }

  @PreAuthorize("hasAuthority('GERENTE')")
  @GetMapping("/buscar-medico")
  public ResponseEntity<List<MedicoResponse>> buscarMedico() {
    return new ResponseEntity<>(service.buscarMedico(), HttpStatus.OK);
  }

  @PreAuthorize("hasAuthority('GERENTE')")
  @DeleteMapping("/deletar-medico/{crm}")
  public ResponseEntity<Void> deletarMedico(@Valid @PathVariable String crm) {
    service.deletarMedico(crm);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PreAuthorize("hasAuthority('GERENTE')")
  @PatchMapping("/atualizar-medico/{crm}")
  public ResponseEntity<MedicoResponse> atualizarMedico(@Valid @PathVariable String crm,
      @Valid @RequestBody MedicoPatchRequest request) {
    return new ResponseEntity<>(service.atualizarMedico(crm, request), HttpStatus.OK);
  }

  @PreAuthorize("hasAuthority('GERENTE')")
  @PostMapping("/criar-atendente")
  public ResponseEntity<AtendenteResponse> criarAtendente(@Valid @RequestBody AtendenteRequest atendenteRequest) {
    return new ResponseEntity<>(service.criarAtendente(atendenteRequest), HttpStatus.CREATED);
  }

  @PreAuthorize("hasAuthority('GERENTE')")
  @GetMapping("/buscar-atendente/{id}")
  public ResponseEntity<AtendenteResponse> buscarAtendente(@Valid @PathVariable Long id) {
    return new ResponseEntity<>(service.buscarAtendente(id), HttpStatus.OK);
  }

  @PreAuthorize("hasAuthority('GERENTE')")
  @GetMapping("/buscar-atendente")
  public ResponseEntity<List<AtendenteResponse>> buscarAtendente() {
    return new ResponseEntity<>(service.buscarAtendente(), HttpStatus.OK);
  }

  @PreAuthorize("hasAuthority('GERENTE')")
  @DeleteMapping("/deletar-atendente/{id}")
  public ResponseEntity<Void> deletarMedico(@Valid @PathVariable Long id) {
    service.deletarAtendente(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PreAuthorize("hasAuthority('GERENTE')")
  @PatchMapping("/atualizar-atendente/{id}")
  public ResponseEntity<AtendenteResponse> atualizarAtendente(@Valid @PathVariable Long id,
      @Valid @RequestBody AtendentePatchRequest request) {
    return new ResponseEntity<>(service.atualizarAtendente(id, request), HttpStatus.OK);
  }
}
