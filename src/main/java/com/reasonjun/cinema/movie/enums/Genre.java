package com.reasonjun.cinema.movie.enums;

import com.reasonjun.common.EnumMapperType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Genre implements EnumMapperType {
    ACTION("ACTION", "액션"),
    ANIMATION("ANIMATION", "애니메이션"),
    DRAMA("DRAMA", "드라마"),
    CRIME("CRIME", "범죄"),
    THRILLER("THRILLER", "스릴러"),
    COMEDY("COMEDY", "코미디"),
    MELODRAMA_ROMANCE("MELODRAMA_ROMANCE", "멜로/로맨스"),
    HORROR("HORROR", "공포(호러)"),
    MYSTERY("MYSTERY", "미스터리"),
    SF("SF", "SF"),
    EROTIC("EROTIC", "성인물(에로)"),
    FANTASY("FANTASY", "판타지"),
    ADVENTURE("ADVENTURE", "어드벤처"),
    HISTORY("HISTORY", "사극"),
    FAMILY("FAMILY", "가족"),
    WAR("WAR", "전쟁"),
    ETC("ETC", "기타"),
    DOCUMENTARY("DOCUMENTARY", "다큐멘터리"),
    MUSICAL("MUSICAL", "뮤지컬"),
    SHOW("SHOW", "공연"),
    WESTERN("WESTERN", "서부극(웨스턴)");

    String code;
    String name;
}