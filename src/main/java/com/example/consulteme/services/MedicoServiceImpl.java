package com.example.consulteme.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.consulteme.dtos.ConsultaPatchRequest;
import com.example.consulteme.dtos.ConsultaResponse;
import com.example.consulteme.enums.Status;
import com.example.consulteme.exceptions.NotFoundException;
import com.example.consulteme.models.Consulta;
import com.example.consulteme.repositories.ConsultaRepositoy;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MedicoServiceImpl implements MedicoService {

  private ConsultaRepositoy consultaRepositoy;

  @Override
  public ConsultaResponse finalizarConsulta(Long id, ConsultaPatchRequest request) {
    Consulta consulta = consultaRepositoy.findById(id)
        .orElseThrow(() -> new NotFoundException("Consulta não cadastrada"));
    if (request.getDiagnostico() != null) {
      consulta.setDiagnostico(request.getDiagnostico());
    }
    if (request.getExame() != null) {
      consulta.setExame(request.getExame());
    }
    if (request.getReceita() != null) {
      consulta.setReceita(request.getReceita());
    }
    consulta.setStatus(Status.CONCLUIDA);
    return new ConsultaResponse(consultaRepositoy.save(consulta));
  }

  @Override
  public List<ConsultaResponse> buscarConsultaPorCrm(String crm) {
    return consultaRepositoy.findConsultaByCrm(crm).stream().map(ConsultaResponse::new).toList();
  }

}
