package com.example.consulteme.services;

import java.util.List;

import com.example.consulteme.dtos.ConsultaRequest;
import com.example.consulteme.dtos.ConsultaResponse;
import com.example.consulteme.dtos.PacienteDTO;
import com.example.consulteme.dtos.PacientePatchRequest;

public interface AtendenteService {
  PacienteDTO criarPaciente(PacienteDTO pacienteDTO);

  PacienteDTO buscarPaciente(String cpf);

  List<PacienteDTO> buscarPaciente();

  PacienteDTO atualizarPaciente(String cpf, PacientePatchRequest pacientePatchRequest);

  ConsultaResponse criarConsulta(ConsultaRequest consultaRequest);
}
