package com.reasonjun.cinema.member.domain;

import com.reasonjun.cinema.domain.Sex;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "member")
public class Member {

  @Id
  @Column(name = "id", nullable = false)
  private String id;

  @Column(name = "brdt", length = 8)
  private String brdt;

  @Column(name = "eml_addr", length = 320)
  private String emlAddr;

  @Column(name = "join_dt")
  private LocalDateTime joinDt;

  @Column(name = "korn_flnm", length = 200)
  private String kornFlnm;

  @Column(name = "mbl_telno", length = 11)
  private String mblTelno;

  @Column(name = "password")
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(name = "sex_cd", length = 30)
  private Sex sex;

  @Column(name = "telno", length = 11)
  private String telno;

  @Column(name = "updt_dt")
  private LocalDateTime updtDt;

  @Column(name = "whdwl_dt")
  private LocalDateTime whdwlDt;

  @Column(name = "whdwl_yn")
  private Character whdwlYn;
}