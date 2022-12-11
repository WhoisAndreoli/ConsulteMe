package com.example.consulteme.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacientePatchRequest {

  @NotNull
  private String nome;
  @NotNull
  private String dtNascimento;
  @NotNull
  private String endereco;
  @NotNull
  private String telefone;
  @NotNull
  private String doencaCronica;
}
