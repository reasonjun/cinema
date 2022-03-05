package com.reasonjun.cinema.movie.domain;

import com.reasonjun.cinema.movie.domain.enums.ActorRole;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "movie_actor")
public class MovieActor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "movie_id")
  private Movie movie;

  @ManyToOne
  @JoinColumn(name = "actor_id")
  private Actor actor;

  @Enumerated(EnumType.STRING)
  @Column(name = "actor_role_cd", length = 30)
  private ActorRole actorRole;

  @Column(name = "actor_role_casting", length = 30)
  private String actorRoleCasting;
}