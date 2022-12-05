package com.example.consulteme.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaPatchRequest {
  private String exame;
  private String diagnostico;
  private String receita;
}
