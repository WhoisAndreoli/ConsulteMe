package com.example.consulteme.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.consulteme.collections.AppUser;
import com.example.consulteme.exceptions.NotFoundException;
import com.example.consulteme.repositories.AppUserRepository;

@Service
public class AppUserServiceImpl implements AppUserService {

  private AppUserRepository appUserRepository;
  private PasswordEncoder encode;

  public AppUserServiceImpl(AppUserRepository appUserRepository, PasswordEncoder encode) {
    this.appUserRepository = appUserRepository;
    this.encode = encode;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    AppUser appUser = appUserRepository.findByEmail(username)
        .orElseThrow(() -> new NotFoundException("Usuario não cadastrado"));

    return new User(appUser.getEmail(), appUser.getSenha(),
        Arrays.asList(new SimpleGrantedAuthority(appUser.getCargo().toString())));
  }

  @Override
  public AppUser save(AppUser user) {
    user.setSenha(encode.encode(user.getSenha()));
    return appUserRepository.save(user);
  }

  @Override
  public List<AppUser> buscar() {

    return appUserRepository.findAll();
  }

}
