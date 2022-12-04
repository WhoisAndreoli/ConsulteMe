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
  @NotBlank
  private String crm;
  @NotBlank
  private String nome;
  @NotBlank
  @Email
  private String email;
  @NotBlank
  private String senha;
  @NotNull
  private Gerente gerente;
}
