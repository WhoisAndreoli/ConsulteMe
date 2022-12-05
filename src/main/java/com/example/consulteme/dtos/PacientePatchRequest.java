package com.example.consulteme.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacientePatchRequest {

  private String nome;
  private String dtNascimento;
  private String endereco;
  private String telefone;
  private String doencaCronica;
}
