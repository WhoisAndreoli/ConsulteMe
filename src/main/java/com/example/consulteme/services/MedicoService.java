package com.example.consulteme.services;

import java.util.List;

import com.example.consulteme.dtos.ConsultaPatchRequest;
import com.example.consulteme.dtos.ConsultaResponse;

public interface MedicoService {

  ConsultaResponse finalizarConsulta(Long id, ConsultaPatchRequest request);

  List<ConsultaResponse> buscarConsulta();
}
