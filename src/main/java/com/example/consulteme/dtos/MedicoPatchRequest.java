package com.example.consulteme.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoPatchRequest {

  @NotNull
  private String nome;
  @NotNull
  @Email(regexp = "^(.+)@(\\S+)$", message = "Email inválido")
  private String email;
  @NotNull
  private String senha;
}
