package com.reasonjun.cinema.movie.domain.enums;

import com.reasonjun.common.EnumMapperType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StaffRole implements EnumMapperType {
  DIRECTOR("감독");

  private String name;
}