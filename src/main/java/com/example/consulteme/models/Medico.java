package com.example.consulteme.models;

import com.example.consulteme.dtos.MedicoRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medico {

  @Id
  private String crm;
  private String nome;
  private String email;
  private String senha;
  @ManyToOne
  @JoinColumn(name = "FK_Gerente")
  private Gerente gerente;

  public Medico(MedicoRequest medicoR) {
    this.crm = medicoR.getCrm();
    this.nome = medicoR.getNome();
    this.email = medicoR.getEmail();
    this.senha = medicoR.getSenha();
    this.gerente = medicoR.getGerente();
  }

}
