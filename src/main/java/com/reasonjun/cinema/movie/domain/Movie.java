package com.reasonjun.cinema.movie.domain;

import com.reasonjun.cinema.movie.domain.enums.MovieGrade;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
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
@Table(name = "movie")
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