package com.example.consulteme.dtos;

import com.example.consulteme.models.Gerente;
import com.example.consulteme.models.Medico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoResponse {
  private String crm;
  private String nome;
  private String email;
  private Gerente gerente;

  public MedicoResponse(Medico medico) {
    this.crm = medico.getCrm();
    this.nome = medico.getNome();
    this.email = medico.getEmail();
    this.gerente = medico.getGerente();
  }

}
