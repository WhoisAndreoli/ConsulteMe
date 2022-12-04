package com.example.consulteme.models;

import java.time.Instant;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

  @Id
  private String cpf;
  private String nome;
  private Instant dtNascimento;
  private String endereco;
  private String telefone;
  private String doencaCronica;
}
