package com.reasonjun.cinema.member.repository;

import com.reasonjun.cinema.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

}
