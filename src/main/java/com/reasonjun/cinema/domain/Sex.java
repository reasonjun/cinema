package com.reasonjun.cinema.domain;

import com.reasonjun.common.EnumMapperType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Sex implements EnumMapperType {
  NOT_KNOWN("0", "여자"),
  MALE("1", "남자"),
  FEMALE("2", "해당없음"),
  NOT_APPLICABLE("9", "알 수 없음");

  private String code;
  private String name;
}
