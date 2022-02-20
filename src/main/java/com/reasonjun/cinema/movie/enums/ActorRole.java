package com.reasonjun.cinema.movie.enums;

import com.reasonjun.common.EnumMapperType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ActorRole implements EnumMapperType {
    LEAD_ROLE("LEAD_ROLE", "주연"),
    SUPPORTING_ROLE("SUPPORTING_ROLE", "조연"),
    MINOR_ROLE("MINOR_ROLE", "단역"),
    EXTRA("EXTRA", "엑스트라"),
    CAMEO("CAMEO", "카메오"),
    FRIENDSHIP_APPEARANCE("FRIENDSHIP_APPEARANCE", "우정출연"),
    SPECIAL_APPEARANCE("SPECIAL_APPEARANCE", "특별출연"),
    GUEST_APPEARANCE("GUEST_APPEARANCE", "찬조출연");

    private String code;
    private String name;
}