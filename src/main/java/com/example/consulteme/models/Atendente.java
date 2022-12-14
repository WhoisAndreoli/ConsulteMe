package com.example.consulteme.models;

import com.example.consulteme.dtos.AtendenteRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class Atendente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String nome;
  private String senha;
  private String email;
  @ManyToOne
  @JoinColumn(name = "FK_Gerente")
  private Gerente gerente;

  public Atendente(AtendenteRequest atendenteR) {
    this.nome = atendenteR.getNome();
    this.senha = atendenteR.getSenha();
    this.email = atendenteR.getEmail();
    this.gerente = atendenteR.getGerente();
  }

}
