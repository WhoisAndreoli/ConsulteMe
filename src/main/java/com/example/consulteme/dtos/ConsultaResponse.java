package com.example.consulteme.dtos;

import com.example.consulteme.enums.Status;
import com.example.consulteme.models.Consulta;
import com.example.consulteme.models.Medico;
import com.example.consulteme.models.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
  @JsonIgnoreProperties({ "senha", "gerente" })
  private Medico medico;
  @JsonIgnoreProperties({ "senha" })
  private Paciente paciente;

  public ConsultaResponse(Consulta consulta) {
    this.id = consulta.getId();
    this.status = consulta.getStatus();
    this.exame = consulta.getExame();
    this.diagnostico = consulta.getDiagnostico();
    this.receita = consulta.getReceita();
    this.medico = consulta.getMedico();
    this.paciente = consulta.getPaciente();
  }

}
