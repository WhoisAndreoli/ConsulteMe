package com.example.consulteme.dtos;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoPatchRequest {

  private String nome;
  @Email(regexp = "^(.+)@(\\S+)$", message = "Email inválido")
  private String email;
  private String senha;
}
