package com.example.consulteme.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControleAdvice {

  @ResponseBody
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public ValidationExceptions error(MethodArgumentNotValidException e) {
    Map<String, String> erros = new HashMap<>();
    e.getBindingResult().getFieldErrors().forEach(error -> erros.put(error.getField(), error.getDefaultMessage()));

    return new ValidationExceptions(erros, HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
        LocalDateTime.now());
  }

  @ResponseBody
  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(code = HttpStatus.NOT_FOUND)
  public ModelExceptions error(NotFoundException e) {
    return new ModelExceptions(e.getMessage(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name());
  }

  @ResponseBody
  @ExceptionHandler(AlreadyCreatedException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public ModelExceptions error(AlreadyCreatedException e) {
    return new ModelExceptions(e.getMessage(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name());
  }
}
