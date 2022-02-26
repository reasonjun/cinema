package com.reasonjun.cinema.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

  /* 404 NOT_FOUND: Resource 를 찾을 수 없음 */
  ACTOR_NOT_FOUND(NOT_FOUND, "일치하는 배우가 없습니다."),
  CINEMA_NOT_FOUND(NOT_FOUND, "일치하는 영화관이 없습니다."),
  MEMBER_NOT_FOUND(NOT_FOUND, "일치하는 사용자가 없습니다."),
  TICKET_NOT_FOUND(NOT_FOUND, "일치하는 티켓이 없습니다.");

  private final HttpStatus httpStatus;
  private final String message;
}