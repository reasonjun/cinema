package com.reasonjun.cinema.member;

import com.reasonjun.cinema.member.controller.MemberController;
import com.reasonjun.cinema.member.domain.Member;
import com.reasonjun.common.SimpleIdentifiableRepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class MemberRepresentationModelAssembler extends
    SimpleIdentifiableRepresentationModelAssembler<Member> {

  public MemberRepresentationModelAssembler() {
    super(MemberController.class);
  }
}