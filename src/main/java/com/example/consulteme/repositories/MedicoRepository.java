package com.example.consulteme.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.consulteme.models.Medico;

public interface MedicoRepository extends JpaRepository<Medico, String> {
  Optional<Medico> findById(String crm);
}
