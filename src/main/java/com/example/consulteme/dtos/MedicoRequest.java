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
public class MedicoRequest {
  @NotBlank(message = "CRM inválido")
  private String crm;

  @NotBlank(message = "Nome inválido")
  private String nome;

  @NotBlank(message = "Email inválido")
  @Email(regexp = "^(.+)@(\\S+)$", message = "Email inválido")
  private String email;

  @NotBlank(message = "Senha inválida")
  private String senha;

  @NotNull
  private Gerente gerente;
}
