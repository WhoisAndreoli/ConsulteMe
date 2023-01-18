package com.example.consulteme.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.consulteme.collections.AppUser;

public interface AppUserRepository extends MongoRepository<AppUser, Long> {
  Optional<AppUser> findByEmail(String email);

  void deleteByEmail(String email);
}
