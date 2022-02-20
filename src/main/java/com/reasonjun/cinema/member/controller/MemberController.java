package com.reasonjun.cinema.member.controller;

import com.reasonjun.cinema.member.MemberRepresentationModelAssembler;
import com.reasonjun.cinema.member.domain.Member;
import com.reasonjun.cinema.member.repository.MemberRepository;
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
        return ResponseEntity.ok(
                assembler.toCollectionModel(repository.findAll()));
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<EntityModel<Member>> findOne(@PathVariable String id) {
        return repository.findById(id)
                .map(assembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
