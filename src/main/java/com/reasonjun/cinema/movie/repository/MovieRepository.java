package com.reasonjun.cinema.movie.repository;

import com.reasonjun.cinema.movie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}