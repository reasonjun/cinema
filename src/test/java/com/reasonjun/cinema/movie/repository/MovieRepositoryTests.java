package com.reasonjun.cinema.movie.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.reasonjun.cinema.movie.domain.Movie;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
class MovieRepositoryTests {

  @Autowired
  MovieRepository repository;

  @Test
  public void findAllTest() {
    List<Movie> movies = repository.findAll();

    assertThat(movies.size()).isEqualTo(1);
  }

  @Test
  public void findByIdTest() {
    assertThat(repository.findById(1).get().getId()).isEqualTo(1);
  }
}