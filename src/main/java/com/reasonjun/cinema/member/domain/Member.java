package com.reasonjun.cinema.member.domain;

import com.reasonjun.cinema.domain.Sex;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
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
    private Timestamp joinDt;

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
    private Timestamp updtDt;

    @Column(name = "whdwl_dt")
    private Timestamp whdwlDt;

    @Column(name = "whdwl_yn")
    private Character whdwlYn;
}