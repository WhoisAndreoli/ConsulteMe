package com.example.consulteme.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.consulteme.collections.AppUser;
import com.example.consulteme.dtos.AtendentePatchRequest;
import com.example.consulteme.dtos.AtendenteRequest;
import com.example.consulteme.dtos.AtendenteResponse;
import com.example.consulteme.dtos.MedicoPatchRequest;
import com.example.consulteme.dtos.MedicoRequest;
import com.example.consulteme.dtos.MedicoResponse;
import com.example.consulteme.enums.Cargo;
import com.example.consulteme.exceptions.AlreadyCreatedException;
import com.example.consulteme.exceptions.NotFoundException;
import com.example.consulteme.models.Atendente;
import com.example.consulteme.models.Medico;
import com.example.consulteme.repositories.AppUserRepository;
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
  private PasswordEncoder encoder;
  private AppUserRepository appUserRepository;

  @Override
  public MedicoResponse criarMedico(MedicoRequest medicoRequest) {

    if (medicoRepository.findById(medicoRequest.getCrm()).isPresent()) {
      throw new AlreadyCreatedException("Médico já cadastrado");
    } else if (gerenteRepository.findById(medicoRequest.getGerente().getId()).isEmpty()) {
      throw new NotFoundException(GERENTE_NAO_CADASTRADO);
    } else if (medicoRepository.findByEmail(medicoRequest.getEmail()).isPresent()) {
      throw new AlreadyCreatedException("Email já cadastrado");
    } else {
      Medico medico = new Medico(medicoRequest);
      medico.setSenha(encoder.encode(medico.getSenha()));
      medico = medicoRepository.save(medico);
      AppUser user = new AppUser(medico.getEmail(), medico.getSenha(), Cargo.MEDICO);
      appUserRepository.save(user);
      return new MedicoResponse(medico);
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
    if (!medicoPatchRequest.getEmail().isBlank()) {
      medico.setEmail(medicoPatchRequest.getEmail());
    }
    if (!medicoPatchRequest.getNome().isBlank()) {
      medico.setNome(medicoPatchRequest.getNome());
    }
    if (!medicoPatchRequest.getSenha().isBlank()) {
      medico.setSenha(medicoPatchRequest.getSenha());
    }
    return new MedicoResponse(medicoRepository.save(medico));
  }

  @Override
  public void deletarMedico(String crm) {
    Medico medico = medicoRepository.findById(crm).orElseThrow(() -> new NotFoundException(MEDICO_NAO_CADASTRADO));
    appUserRepository.deleteByEmail(medico.getEmail());
    medicoRepository.delete(medico);
  }

  @Override
  public AtendenteResponse criarAtendente(AtendenteRequest atendenteRequest) {

    if (gerenteRepository.findById(atendenteRequest.getGerente().getId()).isEmpty()) {
      throw new NotFoundException(GERENTE_NAO_CADASTRADO);
    } else if (atendenteRepository.findByEmail(atendenteRequest.getEmail()).isPresent()) {
      throw new AlreadyCreatedException("Email já cadastrado");
    } else {
      Atendente atendente = new Atendente(atendenteRequest);
      atendente.setSenha(encoder.encode(atendente.getSenha()));
      atendente = atendenteRepository.save(atendente);
      AppUser user = new AppUser(atendente.getEmail(), atendente.getSenha(), Cargo.ATENDENTE);
      appUserRepository.save(user);
      return new AtendenteResponse(atendente);
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
    if (!atendentePatchRequest.getEmail().isBlank()) {
      atendente.setEmail(atendentePatchRequest.getEmail());
    }
    if (!atendentePatchRequest.getNome().isBlank()) {
      atendente.setNome(atendentePatchRequest.getNome());
    }
    if (!atendentePatchRequest.getSenha().isBlank()) {
      atendente.setSenha(atendentePatchRequest.getSenha());
    }
    return new AtendenteResponse(atendenteRepository.save(atendente));
  }

  @Override
  public void deletarAtendente(long id) {
    Atendente atendente = atendenteRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(ATENDENTE_NAO_CADASTRADO));
    appUserRepository.deleteByEmail(atendente.getEmail());
    atendenteRepository.delete(atendente);
  }

}
