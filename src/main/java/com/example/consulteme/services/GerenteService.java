package com.example.consulteme.services;

import java.util.List;

import com.example.consulteme.dtos.AtendentePatchRequest;
import com.example.consulteme.dtos.AtendenteRequest;
import com.example.consulteme.dtos.AtendenteResponse;
import com.example.consulteme.dtos.MedicoPatchRequest;
import com.example.consulteme.dtos.MedicoRequest;
import com.example.consulteme.dtos.MedicoResponse;

public interface GerenteService {
  MedicoResponse criarMedico(MedicoRequest medicoRequest);

  MedicoResponse buscarMedico(String crm);

  List<MedicoResponse> buscarMedico();

  MedicoResponse atualizarMedico(String crm, MedicoPatchRequest medicoPatchRequest);

  void deletarMedico(String crm);

  AtendenteResponse criarAtendente(AtendenteRequest atendenteRequest);

  AtendenteResponse buscarAtendente(Long id);

  List<AtendenteResponse> buscarAtendente();

  AtendenteResponse atualizarAtendente(long id, AtendentePatchRequest atendentePatchRequest);

  void deletarAtendente(long id);
}
