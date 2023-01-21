package com.example.consulteme.config.jwt;

import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.consulteme.models.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

  private AuthenticationManager authenticationManager;
  private String secretKey;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    String token = request.getHeader("Authorization");
    if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
      try {
        LoginRequest loginRequest = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);
        Authentication auth = authenticationManager
            .authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        var user = (User) auth.getPrincipal();
        String jwtToken = JWT.create().withSubject(user.getUsername()).withIssuedAt(Instant.now())
            .withExpiresAt(Instant.now().plus(30, ChronoUnit.MINUTES))
            .withClaim("Cargo", user.getAuthorities().stream().map(Object::toString).collect(Collectors.joining()))
            .withIssuer(request.getRequestURI()).sign(Algorithm.HMAC512(secretKey));
        response.setHeader("Authorization", "Bearer " + jwtToken);
        filterChain.doFilter(request, response);
        return;
      } catch (AuthenticationCredentialsNotFoundException e) {
        throw new AuthenticationCredentialsNotFoundException(e.getMessage());
      }
    }
    token = token.split(" ")[1];
    try {
      JWTVerifier verifier = JWT.require(Algorithm.HMAC512(secretKey)).build();
      DecodedJWT decoded = verifier.verify(token);
      String username = decoded.getSubject();
      String cargo = decoded.getClaim("Cargo").toString();
      var authToken = new UsernamePasswordAuthenticationToken(username, null,
          List.of(new SimpleGrantedAuthority(cargo.substring(1, cargo.length() - 1))));
      authToken.setDetails(new WebAuthenticationDetails(request));
      SecurityContextHolder.getContext().setAuthentication(authToken);
      filterChain.doFilter(request, response);
    } catch (JWTVerificationException e) {
      throw new JWTVerificationException(e.getMessage());
    }
  }

}
