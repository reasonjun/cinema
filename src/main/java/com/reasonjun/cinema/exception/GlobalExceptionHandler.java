package com.reasonjun.cinema.exception;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {BusinessException.class})
  protected ResponseEntity<ExceptionResponse> handleBusinessException(BusinessException e,
      HttpServletRequest request) {
    return ExceptionResponse.toResponseEntity(e.getErrorCode(), request);
  }
}