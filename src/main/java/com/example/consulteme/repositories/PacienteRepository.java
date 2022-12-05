package com.example.consulteme.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.consulteme.models.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, String> {
  Optional<Paciente> findById(String cpf);
}
