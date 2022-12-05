package com.example.consulteme.dtos;

import com.example.consulteme.enums.Status;
import com.example.consulteme.models.Consulta;
import com.example.consulteme.models.Medico;
import com.example.consulteme.models.Paciente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaResponse {
  private long id;
  private Status status;
  private String exame;
  private String diagnostico;
  private String receita;
  private Medico medico;
  private Paciente paciente;

  public ConsultaResponse(Consulta consulta) {
    this.id = consulta.getId();
    this.medico = consulta.getMedico();
    this.paciente = consulta.getPaciente();
    this.status = consulta.getStatus();
  }

}
