package com.example.consulteme.services;

import com.example.consulteme.dtos.MedicoRequest;
import com.example.consulteme.dtos.MedicoResponse;

public interface GerenteService {
  MedicoResponse criarMedico(MedicoRequest medicoRequest);

  MedicoResponse buscarMedico(MedicoRequest medicoRequest);

  MedicoResponse atualizarMedico(MedicoRequest medicoRequest);

  void deletarMedico(MedicoRequest medicoRequest);
}
