package com.reasonjun.cinema.movie.domain;

import com.reasonjun.cinema.domain.Sex;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "staff")
public class Staff {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "korn_flnm", length = 100)
  private String kornFlnm;

  @Column(name = "eng_flnm", length = 100)
  private String engFlnm;

  @Column(name = "brdt", length = 8)
  private String brdt;

  @Enumerated(EnumType.STRING)
  @Column(name = "sex_cd", length = 30)
  private Sex sex;

  @Column(name = "frgnr_yn", nullable = false)
  private Character frgnrYn;
}