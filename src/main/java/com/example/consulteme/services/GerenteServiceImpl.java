package com.example.consulteme.services;

import org.springframework.stereotype.Service;

import com.example.consulteme.dtos.MedicoRequest;
import com.example.consulteme.dtos.MedicoResponse;
import com.example.consulteme.models.Medico;
import com.example.consulteme.repositories.MedicoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GerenteServiceImpl implements GerenteService {

  private MedicoRepository medicoRepository;

  @Override
  public MedicoResponse criarMedico(MedicoRequest medicoRequest) {
    Medico medico = new Medico(medicoRequest);
    return new MedicoResponse(medicoRepository.save(medico));
  }

  @Override
  public MedicoResponse buscarMedico(MedicoRequest medicoRequest) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public MedicoResponse atualizarMedico(MedicoRequest medicoRequest) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void deletarMedico(MedicoRequest medicoRequest) {
    // TODO Auto-generated method stub

  }

}
