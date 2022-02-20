package com.reasonjun.cinema.member;

import com.reasonjun.cinema.member.domain.Member;
import com.reasonjun.cinema.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository repository;

    @Test
    void findAllTest() {
        List<Member> members = repository.findAll();
        assertThat(members.size()).isEqualTo(1);
    }

    @Test
    public void findByIdTest() {
        assertThat(repository.findById("seongjun").map(Member::getId).get()).isEqualTo("seongjun");
    }
}