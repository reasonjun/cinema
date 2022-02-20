package com.reasonjun.cinema.movie.domain;

import com.reasonjun.cinema.movie.enums.MovieGrade;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "movie")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "movie_grade_cd", length = 30)
    private MovieGrade movieGrade;

    @Column(name = "ttl_nm")
    private String ttlNm;

    @Column(name = "sbttl_nm")
    private String sbttlNm;

    @Lob
    @Column(name = "contents")
    private String contents;

    @Column(name = "release_ymd", length = 8)
    private String releaseYmd;

    @Column(name = "release_end_ymd", length = 8)
    private String releaseEndYmd;

    @Column(name = "running_hr", length = 6)
    private String runningHr;

    @OneToMany(mappedBy = "movie")
    private List<MovieActor> movieActors;

    @OneToMany(mappedBy = "movie")
    private List<MovieGenre> movieGenres;

    @OneToMany(mappedBy = "movie")
    private List<MovieStaff> movieStaffs;
}