package com.example.consulteme.dtos;

import com.example.consulteme.models.Atendente;
import com.example.consulteme.models.Gerente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtendenteResponse {
  private long id;
  private String nome;
  private String email;
  private Gerente gerente;

  public AtendenteResponse(Atendente atendente) {
    this.id = atendente.getId();
    this.nome = atendente.getNome();
    this.email = atendente.getEmail();
    this.gerente = atendente.getGerente();
  }

}
