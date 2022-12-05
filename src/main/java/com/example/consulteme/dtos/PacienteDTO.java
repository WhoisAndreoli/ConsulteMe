package com.example.consulteme.dtos;

import org.hibernate.validator.constraints.br.CPF;

import com.example.consulteme.models.Paciente;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDTO {

  @CPF(message = "CPF inválido")
  @NotBlank(message = "CPF inválido")
  private String cpf;
  @NotBlank(message = "Nome inválido")
  private String nome;
  @NotBlank(message = "Data inválida")
  private String dtNascimento;
  @NotBlank(message = "Endereço inválido")
  private String endereco;
  @NotBlank(message = "Telefone inválido")
  private String telefone;
  private String doencaCronica;

  public PacienteDTO(Paciente paciente) {
    this.cpf = paciente.getCpf();
    this.nome = paciente.getNome();
    this.dtNascimento = paciente.getDtNascimento().toString();
    this.endereco = paciente.getEndereco();
    this.telefone = paciente.getTelefone();
    this.doencaCronica = paciente.getDoencaCronica();
  }

}
