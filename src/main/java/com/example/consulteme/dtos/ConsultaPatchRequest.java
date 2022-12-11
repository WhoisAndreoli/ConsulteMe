package com.example.consulteme.dtos;

import com.example.consulteme.enums.Status;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaPatchRequest {
  @NotNull
  private Status status;
  @NotNull
  private String exame;
  @NotNull
  private String diagnostico;
  @NotNull
  private String receita;
}
