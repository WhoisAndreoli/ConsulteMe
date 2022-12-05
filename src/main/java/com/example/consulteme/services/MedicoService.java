package com.example.consulteme.services;

import com.example.consulteme.dtos.ConsultaPatchRequest;
import com.example.consulteme.dtos.ConsultaResponse;

public interface MedicoService {

  ConsultaResponse finalizarConsulta(Long id, ConsultaPatchRequest request);
}
