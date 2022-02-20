package com.reasonjun.cinema.movie.enums;

import com.reasonjun.common.EnumMapperType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MovieGrade implements EnumMapperType {
    ALL_ALLOWED("ALL_ALLOWED", "전체관람가"),
    OVER_TWELVE_YEAR_OLD_ALLOWED("OVER_TWELVE_YEAR_OLD_ALLOWED", "12세 이상 관람가"),
    OVER_FIFTEEN_YEAR_OLD_ALLOWED("OVER_FIFTEEN_YEAR_OLD_ALLOWED", "15세 이상 관람가"),
    YOUTH_NOT_ALLOWED("YOUTH_NOT_ALLOWED", "청소년 관람불가"),
    LIMITED_ALLOWED("LIMITED_ALLOWED", "제한상영가");

    private String code;
    private String name;
}