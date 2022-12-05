package com.example.consulteme.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.consulteme.models.Consulta;

public interface ConsultaRepositoy extends JpaRepository<Consulta, Long> {
  Optional<Consulta> findById(Long id);
}
