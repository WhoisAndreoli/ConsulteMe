package com.example.consulteme.exceptions;

import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ValidationExceptions {
  private final Map<String, String> erros;
  private final long statusCode;
  private final String statusName;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private final LocalDateTime timestamp;

  public ValidationExceptions(Map<String, String> erros, long statusCode, String statusName,
      LocalDateTime timestamp) {
    this.erros = erros;
    this.statusCode = statusCode;
    this.statusName = statusName;
    this.timestamp = timestamp;
  }

  public Map<String, String> getErros() {
    return erros;
  }

  public long getStatusCode() {
    return statusCode;
  }

  public String getStatusName() {
    return statusName;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }
}
