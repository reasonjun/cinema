package com.reasonjun.cinema.member.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.reasonjun.cinema.member.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
class MemberRepositoryTest {

  @Autowired
  MemberRepository repository;

  @Test
  void findAllTest() {
    assertThat(repository.findAll().size()).isEqualTo(1);
  }

  @Test
  public void findByIdTest() {
    assertThat(repository.findById("seongjun").map(Member::getId).get()).isEqualTo("seongjun");
  }
}