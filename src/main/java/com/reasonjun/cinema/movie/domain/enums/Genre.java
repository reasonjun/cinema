package com.reasonjun.cinema.movie.domain.enums;

import com.reasonjun.common.EnumMapperType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Genre implements EnumMapperType {
  ACTION("액션"),
  ANIMATION("애니메이션"),
  DRAMA("드라마"),
  CRIME("범죄"),
  THRILLER("스릴러"),
  COMEDY("코미디"),
  MELODRAMA_ROMANCE("멜로/로맨스"),
  HORROR("공포(호러)"),
  MYSTERY("미스터리"),
  SF("SF"),
  EROTIC("성인물(에로)"),
  FANTASY("판타지"),
  ADVENTURE("어드벤처"),
  HISTORY("사극"),
  FAMILY("가족"),
  WAR("전쟁"),
  ETC("기타"),
  DOCUMENTARY("다큐멘터리"),
  MUSICAL("뮤지컬"),
  SHOW("공연"),
  WESTERN("서부극(웨스턴)");

  String name;
}