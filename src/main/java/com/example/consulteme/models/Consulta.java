package com.example.consulteme.models;

import com.example.consulteme.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Enumerated(EnumType.STRING)
  private Status status;
  private String exame;
  private String diagnostico;
  private String receita;
  @ManyToOne
  @JoinColumn(name = "FK_Medico")
  private Medico medico;
  @ManyToOne
  @JoinColumn(name = "FK_Paciente")
  private Paciente paciente;
}
