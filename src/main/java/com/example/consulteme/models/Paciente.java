package com.example.consulteme.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.example.consulteme.dtos.PacienteDTO;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

  @Id
  private String cpf;
  private String nome;
  private LocalDate dtNascimento;
  private String endereco;
  private String telefone;
  private String doencaCronica;

  public Paciente(PacienteDTO pacienteDTO) {
    this.cpf = pacienteDTO.getCpf();
    this.nome = pacienteDTO.getNome();
    this.dtNascimento = LocalDate.parse(pacienteDTO.getDtNascimento(), DateTimeFormatter.ofPattern("d/M/uuuu"));
    this.endereco = pacienteDTO.getEndereco();
    this.telefone = pacienteDTO.getTelefone();
    this.doencaCronica = pacienteDTO.getDoencaCronica();
  }

}
