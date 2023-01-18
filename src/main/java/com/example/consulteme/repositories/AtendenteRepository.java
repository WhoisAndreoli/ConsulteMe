package com.example.consulteme.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.consulteme.models.Atendente;

public interface AtendenteRepository extends JpaRepository<Atendente, Long> {
  Optional<Atendente> findById(Long id);

  Optional<Atendente> findByEmail(String email);
}
