package com.example.consulteme.dtos;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtendentePatchRequest {
  private String nome;
  private String senha;
  @Email(regexp = "^(.+)@(\\S+)$", message = "Email inválido")
  private String email;
}
