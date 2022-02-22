package com.reasonjun.cinema.actor.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.reasonjun.cinema.movie.domain.Actor;
import com.reasonjun.cinema.movie.repository.ActorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
public class ActorRepositoryTests {

    @Autowired
    ActorRepository repository;

    @Test
    public void findAllTest() {
        assertThat(repository.findAll().size()).isEqualTo(8);
    }

    @Test
    public void findByIdTest() {
        assertThat(repository.findById(1).map(Actor::getId).get()).isEqualTo(1);
    }
}
