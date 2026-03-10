package com.api.errors;

import lombok.Getter;

@Getter
public class ApiErrorResponse {
  private int status;
  private String path;
  private String error;
  private String message;
  private String timestamp;

  public ApiErrorResponse(String timestamp, int status, String message, String path, String error) {
    this.path = path;
    this.error = error;
    this.status = status;
    this.message = message;
    this.timestamp = timestamp;
  }
}
