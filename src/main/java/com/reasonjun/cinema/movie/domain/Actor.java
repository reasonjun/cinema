package com.reasonjun.cinema.movie.domain;

import com.reasonjun.cinema.domain.Sex;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "actor")
public class Actor {

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

    @Column(name = "frgnr_yn")
    private Character frgnrYn;
}