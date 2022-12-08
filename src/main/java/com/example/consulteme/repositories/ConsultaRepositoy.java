package com.example.consulteme.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.consulteme.models.Consulta;

public interface ConsultaRepositoy extends JpaRepository<Consulta, Long> {
  Optional<Consulta> findById(Long id);

  @Query(value = "Select u from Consulta u join u.medico m where m.crm = ?1 and u.status = 'FILA' order by u.id")
  List<Consulta> findConsultaByCrm(String crm);
}
