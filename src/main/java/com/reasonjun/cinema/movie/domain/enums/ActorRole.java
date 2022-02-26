package com.reasonjun.cinema.movie.domain.enums;

import com.reasonjun.common.EnumMapperType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ActorRole implements EnumMapperType {
  LEAD_ROLE("주연"),
  SUPPORTING_ROLE("조연"),
  MINOR_ROLE("단역"),
  EXTRA("엑스트라"),
  CAMEO("카메오"),
  FRIENDSHIP_APPEARANCE("우정출연"),
  SPECIAL_APPEARANCE("특별출연"),
  GUEST_APPEARANCE("찬조출연");

  private String name;
}