package com.reasonjun.cinema.movie.enums;

import com.reasonjun.common.EnumMapperType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StaffRole implements EnumMapperType {
    DIRECTOR("DIRECTOR", "감독");

    private String code;
    private String name;
}