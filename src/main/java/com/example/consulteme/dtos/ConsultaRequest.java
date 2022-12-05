package com.example.consulteme.dtos;

import com.example.consulteme.models.Medico;
import com.example.consulteme.models.Paciente;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaRequest {
  @NotNull
  private Medico medico;
  @NotNull
  private Paciente paciente;
}
