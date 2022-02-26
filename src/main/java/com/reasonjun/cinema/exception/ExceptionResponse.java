package com.reasonjun.cinema.exception;

import java.time.Instant;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

@Getter
@Builder
public class ExceptionResponse {

  private final Instant timeStamp = Instant.now();
  private final int status;
  private final String error;
  private final String code;
  private final String message;
  private final String path;

  public static ResponseEntity<ExceptionResponse> toResponseEntity(ErrorCode errorCode,
      WebRequest request) {
    System.out.println("request = " + request);
    String contextPath = request.getContextPath();
    System.out.println("contextPath = " + contextPath);
    return ResponseEntity
        .status(errorCode.getHttpStatus())
        .body(ExceptionResponse.builder()
            .status(errorCode.getHttpStatus().value())
            .error(errorCode.getHttpStatus().name())
            .code(errorCode.name())
            .message(errorCode.getMessage())
            .path(request.getContextPath())
            .build()
        );
  }
}