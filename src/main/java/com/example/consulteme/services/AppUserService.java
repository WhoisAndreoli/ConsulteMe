package com.example.consulteme.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.consulteme.collections.AppUser;

public interface AppUserService extends UserDetailsService {

  AppUser save(AppUser user);

  List<AppUser> buscar();

}
