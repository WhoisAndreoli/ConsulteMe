package com.example.consulteme.collections;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.consulteme.enums.Cargo;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
public class AppUser {

  private String email;
  private String senha;
  @Enumerated(EnumType.STRING)
  private Cargo cargo;

  public AppUser(String email, String senha, Cargo cargo) {
    this.email = email;
    this.senha = senha;
    this.cargo = cargo;
  }

}
