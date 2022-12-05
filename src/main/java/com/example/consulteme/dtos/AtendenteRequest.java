package com.example.consulteme.dtos;

import com.example.consulteme.models.Gerente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtendenteRequest {
  @NotBlank
  private String nome;
  @NotBlank
  private String senha;
  @NotBlank(message = "Email inválido")
  @Email(regexp = "^(.+)@(\\S+)$", message = "Email inválido")
  private String email;
  @NotNull
  private Gerente gerente;
}
