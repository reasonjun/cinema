package com.reasonjun.cinema.member.controller;

import static com.reasonjun.cinema.exception.ErrorCode.MEMBER_NOT_FOUND;

import com.reasonjun.cinema.exception.BusinessException;
import com.reasonjun.cinema.member.MemberRepresentationModelAssembler;
import com.reasonjun.cinema.member.domain.Member;
import com.reasonjun.cinema.member.repository.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {

  private final MemberRepository repository;
  private final MemberRepresentationModelAssembler assembler;

  @GetMapping("/members")
  public ResponseEntity<CollectionModel<EntityModel<Member>>> findAll() {
    List<Member> members = repository.findAll();

    if (members.isEmpty()) {
      throw new BusinessException(MEMBER_NOT_FOUND);
    }

    return ResponseEntity.ok(assembler.toCollectionModel(members));
  }

  @GetMapping("/members/{id}")
  public ResponseEntity<EntityModel<Member>> findOne(@PathVariable String id) {
    return repository.findById(id)
        .map(assembler::toModel)
        .map(ResponseEntity::ok)
        .orElseThrow(() -> new BusinessException(MEMBER_NOT_FOUND));
  }
}
