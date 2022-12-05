package com.example.consulteme.exceptions;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ModelExceptions {
  private String error;
  private final long statusCode;
  private final String statusName;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private final LocalDateTime timestamp = LocalDateTime.now();

  public ModelExceptions(String error, long statusCode, String statusName) {
    this.error = error;
    this.statusCode = statusCode;
    this.statusName = statusName;
  }

  public String getErro() {
    return error;
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
