package com.reasonjun.cinema.movie.domain;

import com.reasonjun.cinema.movie.enums.ActorRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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