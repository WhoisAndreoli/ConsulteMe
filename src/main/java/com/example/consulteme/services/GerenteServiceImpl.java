package com.example.consulteme.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.consulteme.dtos.AtendentePatchRequest;
import com.example.consulteme.dtos.AtendenteRequest;
import com.example.consulteme.dtos.AtendenteResponse;
import com.example.consulteme.dtos.MedicoPatchRequest;
import com.example.consulteme.dtos.MedicoRequest;
import com.example.consulteme.dtos.MedicoResponse;
import com.example.consulteme.exceptions.AlreadyCreatedException;
import com.example.consulteme.exceptions.NotFoundException;
import com.example.consulteme.models.Atendente;
import com.example.consulteme.models.Medico;
import com.example.consulteme.repositories.AtendenteRepository;
import com.example.consulteme.repositories.GerenteRepository;
import com.example.consulteme.repositories.MedicoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GerenteServiceImpl implements GerenteService {

  private static final String GERENTE_NAO_CADASTRADO = "Gerente não cadastrado";
  private static final String ATENDENTE_NAO_CADASTRADO = "Atendente não cadastrado";
  private static final String MEDICO_NAO_CADASTRADO = "Médico não cadastrado";
  private MedicoRepository medicoRepository;
  private GerenteRepository gerenteRepository;
  private AtendenteRepository atendenteRepository;

  @Override
  public MedicoResponse criarMedico(MedicoRequest medicoRequest) {

    if (medicoRepository.findById(medicoRequest.getCrm()).isPresent()) {
      throw new AlreadyCreatedException("Médico já cadastrado");
    } else if (gerenteRepository.findById(medicoRequest.getGerente().getId()).isEmpty()) {
      throw new NotFoundException(GERENTE_NAO_CADASTRADO);
    } else {
      Medico medico = new Medico(medicoRequest);
      return new MedicoResponse(medicoRepository.save(medico));
    }
  }

  @Override
  public MedicoResponse buscarMedico(String crm) {
    Medico medico = medicoRepository.findById(crm).orElseThrow(() -> new NotFoundException(MEDICO_NAO_CADASTRADO));
    return new MedicoResponse(medico);
  }

  @Override
  public List<MedicoResponse> buscarMedico() {
    return medicoRepository.findAll().stream().map(MedicoResponse::new).toList();
  }

  @Override
  public MedicoResponse atualizarMedico(String crm, MedicoPatchRequest medicoPatchRequest) {
    Medico medico = medicoRepository.findById(crm).orElseThrow(() -> new NotFoundException(MEDICO_NAO_CADASTRADO));
    if (medicoPatchRequest.getEmail() != null) {
      medico.setEmail(medicoPatchRequest.getEmail());
    }
    if (medicoPatchRequest.getNome() != null) {
      medico.setNome(medicoPatchRequest.getNome());
    }
    if (medicoPatchRequest.getSenha() != null) {
      medico.setSenha(medicoPatchRequest.getSenha());
    }
    return new MedicoResponse(medicoRepository.save(medico));
  }

  @Override
  public void deletarMedico(String crm) {
    Medico medico = medicoRepository.findById(crm).orElseThrow(() -> new NotFoundException(MEDICO_NAO_CADASTRADO));
    medicoRepository.delete(medico);
  }

  @Override
  public AtendenteResponse criarAtendente(AtendenteRequest atendenteRequest) {
    if (gerenteRepository.findById(atendenteRequest.getGerente().getId()).isEmpty()) {
      throw new NotFoundException(GERENTE_NAO_CADASTRADO);
    } else {
      Atendente atendente = new Atendente(atendenteRequest);
      return new AtendenteResponse(atendenteRepository.save(atendente));
    }
  }

  @Override
  public AtendenteResponse buscarAtendente(Long id) {
    Atendente atendente = atendenteRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(ATENDENTE_NAO_CADASTRADO));
    return new AtendenteResponse(atendente);

  }

  @Override
  public List<AtendenteResponse> buscarAtendente() {
    return atendenteRepository.findAll().stream().map(AtendenteResponse::new).toList();
  }

  @Override
  public AtendenteResponse atualizarAtendente(long id, AtendentePatchRequest atendentePatchRequest) {
    Atendente atendente = atendenteRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(ATENDENTE_NAO_CADASTRADO));
    if (atendentePatchRequest.getEmail() != null) {
      atendente.setEmail(atendentePatchRequest.getEmail());
    }
    if (atendentePatchRequest.getNome() != null) {
      atendente.setNome(atendentePatchRequest.getNome());
    }
    if (atendentePatchRequest.getSenha() != null) {
      atendente.setSenha(atendentePatchRequest.getSenha());
    }
    return new AtendenteResponse(atendenteRepository.save(atendente));
  }

  @Override
  public void deletarAtendente(long id) {
    Atendente atendente = atendenteRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(ATENDENTE_NAO_CADASTRADO));
    atendenteRepository.delete(atendente);
  }

}
