package com.reasonjun.cinema.movie.controller;


import static com.reasonjun.cinema.exception.ErrorCode.ACTOR_NOT_FOUND;

import com.reasonjun.cinema.exception.BusinessException;
import com.reasonjun.cinema.movie.ActorRepresentationModelAssembler;
import com.reasonjun.cinema.movie.domain.Actor;
import com.reasonjun.cinema.movie.repository.ActorRepository;
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
public class ActorController {

  private final ActorRepository repository;
  private final ActorRepresentationModelAssembler assembler;

  @GetMapping("/actors")
  public ResponseEntity<CollectionModel<EntityModel<Actor>>> findAll() {
    List<Actor> actors = repository.findAll();

    if (actors.isEmpty()) {
      throw new BusinessException(ACTOR_NOT_FOUND);
    }

    return ResponseEntity.ok(assembler.toCollectionModel(actors));
  }

  @GetMapping("/actors/{id}")
  public ResponseEntity<EntityModel<Actor>> findOne(@PathVariable int id) {
    return repository.findById(id)
        .map(assembler::toModel)
        .map(ResponseEntity::ok)
        .orElseThrow(() -> new BusinessException(ACTOR_NOT_FOUND));
  }
}