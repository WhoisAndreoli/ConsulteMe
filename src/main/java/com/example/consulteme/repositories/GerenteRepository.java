package com.example.consulteme.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.consulteme.models.Gerente;

public interface GerenteRepository extends JpaRepository<Gerente, Long> {

  Optional<Gerente> findById(Long id);
}
