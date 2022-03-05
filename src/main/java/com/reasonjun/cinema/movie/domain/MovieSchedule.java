package com.reasonjun.cinema.movie.domain;

import com.reasonjun.cinema.domain.Ticket;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "movie_schedule")
public class MovieSchedule {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "movie_id", nullable = false)
  private Integer movieId;

  @Column(name = "cinema_theater_id", nullable = false)
  private Integer cinemaTheaterId;

  @Column(name = "bgng_dt", nullable = false)
  private LocalDateTime bgngDt;

  @Column(name = "end_dt", nullable = false)
  private LocalDateTime endDt;

  @OneToMany(mappedBy = "movieSchedule", orphanRemoval = true)
  private List<Ticket> tickets;
}