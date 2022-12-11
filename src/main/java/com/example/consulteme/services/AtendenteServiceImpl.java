package com.example.consulteme.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.consulteme.dtos.ConsultaRequest;
import com.example.consulteme.dtos.ConsultaResponse;
import com.example.consulteme.dtos.PacienteDTO;
import com.example.consulteme.dtos.PacientePatchRequest;
import com.example.consulteme.exceptions.AlreadyCreatedException;
import com.example.consulteme.exceptions.NotFoundException;
import com.example.consulteme.models.Consulta;
import com.example.consulteme.models.Paciente;
import com.example.consulteme.repositories.ConsultaRepositoy;
import com.example.consulteme.repositories.MedicoRepository;
import com.example.consulteme.repositories.PacienteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AtendenteServiceImpl implements AtendenteService {

  private static final String PACIENTE_NAO_CADASTRADO = "Paciente não cadastrado";
  private PacienteRepository pacienteRepository;
  private MedicoRepository medicoRepository;
  private ConsultaRepositoy consultaRepositoy;

  @Override
  public PacienteDTO criarPaciente(PacienteDTO pacienteDTO) {
    if (pacienteRepository.findById(pacienteDTO.getCpf()).isPresent()) {
      throw new AlreadyCreatedException("Paciente já cadastrado");
    } else {
      Paciente paciente = new Paciente(pacienteDTO);
      return new PacienteDTO(pacienteRepository.save(paciente));
    }
  }

  @Override
  public PacienteDTO buscarPaciente(String cpf) {
    Paciente paciente = pacienteRepository.findById(cpf)
        .orElseThrow(() -> new NotFoundException(PACIENTE_NAO_CADASTRADO));
    return new PacienteDTO(paciente);
  }

  @Override
  public List<PacienteDTO> buscarPaciente() {
    return pacienteRepository.findAll().stream().map(PacienteDTO::new).toList();
  }

  @Override
  public PacienteDTO atualizarPaciente(String cpf, PacientePatchRequest pacienteR) {
    Paciente paciente = pacienteRepository.findById(cpf)
        .orElseThrow(() -> new NotFoundException(PACIENTE_NAO_CADASTRADO));
    if (!pacienteR.getNome().isBlank()) {
      paciente.setNome(pacienteR.getNome());
    }
    if (!pacienteR.getDoencaCronica().isBlank()) {
      paciente.setDoencaCronica(pacienteR.getDoencaCronica());
    }
    if (!pacienteR.getEndereco().isBlank()) {
      paciente.setEndereco(pacienteR.getEndereco());
    }
    if (!pacienteR.getTelefone().isBlank()) {
      paciente.setTelefone(pacienteR.getTelefone());
    }
    if (!pacienteR.getDtNascimento().isBlank()) {
      paciente.setDtNascimento(LocalDate.parse(pacienteR.getDtNascimento(), DateTimeFormatter.ofPattern("d/M/uuuu")));
    }
    return new PacienteDTO(pacienteRepository.save(paciente));
  }

  @Override
  public ConsultaResponse criarConsulta(ConsultaRequest consultaRequest) {
    if (pacienteRepository.findById(consultaRequest.getPaciente().getCpf()).isPresent()) {
      if (medicoRepository.findById(consultaRequest.getMedico().getCrm()).isPresent()) {
        Consulta consulta = new Consulta(consultaRequest);
        return new ConsultaResponse(consultaRepositoy.save(consulta));
      } else {
        throw new NotFoundException("Médico não cadastrado");
      }
    } else {
      throw new NotFoundException(PACIENTE_NAO_CADASTRADO);
    }

  }

  @Override
  public List<ConsultaResponse> buscarConsulta() {
    return consultaRepositoy.findAllConsulta().stream().map(ConsultaResponse::new).toList();
  }

}
