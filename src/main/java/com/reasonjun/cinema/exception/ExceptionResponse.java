package com.reasonjun.cinema.exception;

import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
public class ExceptionResponse {

  private final LocalDateTime localDateTime = LocalDateTime.now();
  private final int status;
  private final String error;
  private final String code;
  private final String message;
  private final String path;

  public static ResponseEntity<ExceptionResponse> toResponseEntity(ErrorCode errorCode,
      HttpServletRequest request) {
    return ResponseEntity
        .status(errorCode.getHttpStatus())
        .body(ExceptionResponse.builder()
            .status(errorCode.getHttpStatus().value())
            .error(errorCode.getHttpStatus().name())
            .code(errorCode.name())
            .message(errorCode.getMessage())
            .path(request.getRequestURI())
            .build()
        );
  }
}